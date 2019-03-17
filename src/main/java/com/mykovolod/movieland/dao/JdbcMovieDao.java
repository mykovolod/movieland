package com.mykovolod.movieland.dao;

import com.mykovolod.movieland.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class JdbcMovieDao {
    private static final String GET_ALL_QUERY = "SELECT movie_id, name, name_original, year, country, rating, \n" +
            "price, picture_path FROM movieland.movies;";
    private static final String GET_RANDOM_QUERY = "SELECT movie_id, name, name_original, year, country, rating, \n" +
            "price, picture_path FROM movieland.movies limit :limit;";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<Movie> getAll() {
        return jdbcTemplate.query(GET_ALL_QUERY, new BeanPropertyRowMapper(Movie.class));
    }


    public List<Movie> getRandom(int limit) {
        final Map<String, Object> param = new HashMap<>();
        param.put("limit", limit);
        return jdbcTemplate.query(GET_RANDOM_QUERY, param, new BeanPropertyRowMapper(Movie.class));
    }
}
