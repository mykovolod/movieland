package com.mykovolod.movieland.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@JsonPropertyOrder({"genreId", "name"})
public class Genre {
    @JsonProperty("id")
    private int genreId;
    private String name;
}
