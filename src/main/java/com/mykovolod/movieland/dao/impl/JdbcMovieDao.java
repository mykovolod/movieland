package com.mykovolod.movieland.dao.impl;

import com.mykovolod.movieland.dao.MovieDao;
import com.mykovolod.movieland.model.Movie;
import com.mykovolod.movieland.service.impl.QueryBuilder;
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
public class JdbcMovieDao implements MovieDao {
    private static final BeanPropertyRowMapper MOVIE_ROW_MAPPER = new BeanPropertyRowMapper(Movie.class);
    private static final String GET_ALL_QUERY = "SELECT movie_id, name, name_original, year, country, rating,"
            + "price, picture_path FROM movieland.movies";
    private static final String GET_RANDOM_QUERY = "SELECT movie_id, name, name_original, year, country, rating,"
            + "price, picture_path FROM movieland.movies limit :limit;";
    private static final String GET_BY_GENRE_ID_QUERY = "SELECT m.movie_id, m.name, m.name_original, m.year, m.country,"
            + "m.rating, m.price, m.picture_path FROM movieland.movies m "
            + "inner join movieland.movie_genre gm on gm.movie_id = m.movie_id "
            + "where gm.genre_id = :genreId";

    private final QueryBuilder queryBuilder;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> getAll(final MovieLandRequestParam movieLandRequestParam) {
        String finalQuery = queryBuilder.addSorting(GET_ALL_QUERY, movieLandRequestParam);
        return jdbcTemplate.query(finalQuery, MOVIE_ROW_MAPPER);
    }

    @Override
    public List<Movie> getRandom(final int limit) {
        final Map<String, Object> param = new HashMap<>();
        param.put("limit", limit);

        return jdbcTemplate.query(GET_RANDOM_QUERY, param, MOVIE_ROW_MAPPER);
    }

    @Override
    public List<Movie> getMovieByGenre(final int genreId) {
        final Map<String, Object> param = new HashMap<>();
        param.put("genreId", genreId);
        return jdbcTemplate.query(GET_BY_GENRE_ID_QUERY, param, MOVIE_ROW_MAPPER);
    }
}
