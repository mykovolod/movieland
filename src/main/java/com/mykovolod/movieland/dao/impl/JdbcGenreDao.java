package com.mykovolod.movieland.dao.impl;

import com.mykovolod.movieland.dao.GenreDao;
import com.mykovolod.movieland.dao.mapper.GenreRowMapper;
import com.mykovolod.movieland.model.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcGenreDao implements GenreDao {
    private static final GenreRowMapper GENRE_ROW_MAPPER = new GenreRowMapper();
    private static final String GET_ALL_QUERY = "SELECT genre_id, name FROM movieland.genres";
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<Genre> getAll() {
        return jdbcTemplate.query(GET_ALL_QUERY, GENRE_ROW_MAPPER);
    }

}
