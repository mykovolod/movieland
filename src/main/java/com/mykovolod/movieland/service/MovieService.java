package com.mykovolod.movieland.service;


import com.mykovolod.movieland.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAll();

    List<Movie> getRandom();
}
