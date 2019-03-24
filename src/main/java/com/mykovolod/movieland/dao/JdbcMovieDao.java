package com.mykovolod.movieland.dao;

import com.mykovolod.movieland.model.Movie;
import com.mykovolod.movieland.service.QueryBuilder;
import com.mykovolod.movieland.sorting.MovieLandRequestParam;
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
    private static final BeanPropertyRowMapper movieRowMapper = new BeanPropertyRowMapper(Movie.class);
    private static final String GET_ALL_QUERY = "SELECT movie_id, name, name_original, year, country, rating," +
            "price, picture_path FROM movieland.movies";
    private static final String GET_RANDOM_QUERY = "SELECT movie_id, name, name_original, year, country, rating," +
            "price, picture_path FROM movieland.movies limit :limit;";
    private static final String GET_BY_GENRE_ID_QUERY = "SELECT m.movie_id, m.name, m.name_original, m.year, m.country," +
            "m.rating, m.price, m.picture_path FROM movieland.movies m " +
            "inner join movieland.movie_genre gm on gm.movie_id = m.movie_id " +
            "where gm.genre_id = :genreId";

    private final QueryBuilder queryBuilder;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<Movie> getAll(MovieLandRequestParam movieLandRequestParam) {
        String finalQuery = queryBuilder.build(GET_ALL_QUERY, movieLandRequestParam);
        return jdbcTemplate.query(finalQuery, movieRowMapper);
    }

    public List<Movie> getRandom(int limit) {
        final Map<String, Object> param = new HashMap<>();
        param.put("limit", limit);

        return jdbcTemplate.query(GET_RANDOM_QUERY, param, movieRowMapper);
    }

    public List<Movie> getMovieByGenre(int genreId) {
        final Map<String, Object> param = new HashMap<>();
        param.put("genreId", genreId);
        return jdbcTemplate.query(GET_BY_GENRE_ID_QUERY, param, movieRowMapper);
    }
}
