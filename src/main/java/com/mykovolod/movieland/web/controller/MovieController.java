package com.mykovolod.movieland.web.controller;

import com.mykovolod.movieland.model.Movie;
import com.mykovolod.movieland.service.MovieService;
import com.mykovolod.movieland.sorting.MovieLandRequestParam;
import com.mykovolod.movieland.sorting.SortDirection;
import com.mykovolod.movieland.sorting.SortParamConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getAll(@RequestParam(value = "rating", required = false) final SortDirection ratingSortDirection,
                              @RequestParam(value = "price", required = false) final SortDirection priceSortDirection) {

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
    public List<Movie> getRandom(@PathVariable final int genreId) {
        return movieService.getMovieByGenre(genreId);
    }

    @InitBinder
    public void initBinder(final WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(SortDirection.class, new SortParamConverter());
    }

}
