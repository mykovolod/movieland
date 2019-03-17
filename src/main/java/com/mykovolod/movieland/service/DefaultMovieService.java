package com.mykovolod.movieland.service;

import com.mykovolod.movieland.dao.JdbcMovieDao;
import com.mykovolod.movieland.model.Movie;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultMovieService implements MovieService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMovieService.class);
    private final JdbcMovieDao movieDao;

    @Value("${random.movies.limit}")
    private int limit;

    @Override
    public List<Movie> getAll() {
        List<Movie> movieDaoAll = movieDao.getAll();
        LOGGER.debug("Return movies: " + movieDaoAll);
        return movieDaoAll;
    }

    @Override
    public List<Movie> getRandom() {
        List<Movie> movieDaoAll = movieDao.getRandom(limit);
        LOGGER.debug("Return movies: " + movieDaoAll);
        return movieDaoAll;
    }
}
