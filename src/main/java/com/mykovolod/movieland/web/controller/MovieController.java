package com.mykovolod.movieland.web.controller;

import com.mykovolod.movieland.model.Movie;
import com.mykovolod.movieland.service.MovieService;
import com.mykovolod.movieland.sorting.SortDirection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.mykovolod.movieland.sorting.MovieLandRequestParam;

import java.util.List;

@RestController
@RequestMapping("movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getAll(@RequestParam(value = "rating", required = false) SortDirection ratingSortDirection,
                              @RequestParam(value = "price", required = false) SortDirection priceSortDirection) {

        if (ratingSortDirection == SortDirection.ASC) {
            throw new IllegalArgumentException("Ascending ordering is not supported for rating");
        }
        MovieLandRequestParam movieLandRequestParam = new MovieLandRequestParam();
        movieLandRequestParam.addSortingParam("rating", ratingSortDirection);
        movieLandRequestParam.addSortingParam("price", priceSortDirection);

        return movieService.getAll(movieLandRequestParam);
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
