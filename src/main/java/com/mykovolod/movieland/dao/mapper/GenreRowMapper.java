package com.mykovolod.movieland.dao.mapper;
import com.mykovolod.movieland.model.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
        int genreId = resultSet.getInt("genre_id");
        String name = resultSet.getString("name");
        return new Genre(genreId, name);
    }
}