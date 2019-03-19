package com.mykovolod.movieland.service;


import com.mykovolod.movieland.model.Movie;
import com.mykovolod.movieland.sorting.MovieSortParam;

import java.util.List;

public interface MovieService {

    List<Movie> getAll(MovieSortParam movieSortParam);

    List<Movie> getRandom();

    List<Movie> getMovieByGenre(int genreId);
}
