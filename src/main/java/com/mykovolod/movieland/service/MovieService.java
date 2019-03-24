package com.mykovolod.movieland.service;


import com.mykovolod.movieland.model.Movie;
import com.mykovolod.movieland.sorting.MovieLandRequestParam;

import java.util.List;

public interface MovieService {

    List<Movie> getAll(MovieLandRequestParam movieSortParam);

    List<Movie> getRandom();

    List<Movie> getMovieByGenre(int genreId);
}
