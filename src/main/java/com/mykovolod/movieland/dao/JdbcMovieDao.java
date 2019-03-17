package com.mykovolod.movieland.dao;

import com.mykovolod.movieland.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcMovieDao {
    private static final String GET_ALL_QUERY = "SELECT movie_id, name, name_original, year, country, rating,\n" +
            "       price, picture_path FROM movieland.movies;";

    private final JdbcTemplate jdbcTemplate;

    public List<Movie> getAll() {
        return jdbcTemplate.query(GET_ALL_QUERY, new BeanPropertyRowMapper(Movie.class));
    }


}
