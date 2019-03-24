package com.mykovolod.movieland.dao;

import com.mykovolod.movieland.model.Movie;
import com.mykovolod.movieland.sorting.MovieLandRequestParam;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll(MovieLandRequestParam movieLandRequestParam);

    List<Movie> getRandom(int limit);

    List<Movie> getMovieByGenre(int genreId);
}
