package com.mykovolod.movieland.service;

import com.mykovolod.movieland.dao.MovieDao;
import com.mykovolod.movieland.model.Movie;
import com.mykovolod.movieland.sorting.MovieSortParam;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultMovieService implements MovieService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final MovieDao movieDao;

    @Value("${random.movies.limit}")
    private int limit;

    @Override
    public List<Movie> getAll(MovieSortParam movieSortParam) {
        List<Movie> movieDaoAll = movieDao.getAll(movieSortParam);
        log.debug("Return movies: {}", movieDaoAll);
        return movieDaoAll;
    }

    @Override
    public List<Movie> getRandom() {
        List<Movie> movieDaoAll = movieDao.getRandom(limit);
        log.debug("Return movies: {}", movieDaoAll);
        return movieDaoAll;
    }

    @Override
    public List<Movie> getMovieByGenre(int genre) {
        List<Movie> movieDaoAll = movieDao.getMovieByGenre(genre);
        log.debug("Return movies: {}", movieDaoAll);
        return movieDaoAll;
    }
}
