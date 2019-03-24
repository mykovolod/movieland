package com.mykovolod.movieland.dao;

import com.mykovolod.movieland.model.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DefaultJdbcGenreDao implements JdbcGenreDao {
    private static final BeanPropertyRowMapper movieRowMapper = new BeanPropertyRowMapper(Genre.class);
    private static final String GET_ALL_QUERY = "SELECT genre_id, name FROM movieland.genres;";
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<Genre> getAll() {
        return jdbcTemplate.query(GET_ALL_QUERY, movieRowMapper);
    }

}
