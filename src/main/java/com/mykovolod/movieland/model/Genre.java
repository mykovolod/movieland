package com.mykovolod.movieland.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@JsonPropertyOrder({"genreId", "name"})
public class Genre {
    @JsonProperty("id")
    private int genreId;
    private String name;
}
