package com.mykovolod.movieland.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Movie {
    @JsonProperty("id")
    private int movieId;
    @JsonProperty("nameRussian")
    private String name;
    @JsonProperty("nameNative")
    private String nameOriginal;
    @JsonProperty("yearOfRelease")
    private String year;
    private double rating;
    private double price;
    private String picturePath;
}
