package com.mykovolod.movieland.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"genre_id", "name"})
public class Genre {
    @JsonProperty("id")
    private int genre_id;
    private String name;
}
