package com.mykovolod.movieland.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"genreId", "name"})
public class Genre {
    @JsonProperty("id")
    private int genreId;
    private String name;
}
