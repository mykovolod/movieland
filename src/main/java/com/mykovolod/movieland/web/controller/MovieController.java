package com.mykovolod.movieland.web.controller;

import com.mykovolod.movieland.model.Movie;
import com.mykovolod.movieland.service.MovieService;
import com.mykovolod.movieland.sorting.MovieSortParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getAll(MovieSortParam movieSortParam) {
        return movieService.getAll(movieSortParam);
    }

    @GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getRandom() {
        return movieService.getRandom();
    }

    @GetMapping(value = "genre/{genreId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getRandom(@PathVariable int genreId) {
        return movieService.getMovieByGenre(genreId);
    }

}
