package com.mykovolod.movieland.dao.mapper;

import com.mykovolod.movieland.model.Genre;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GenreRowMapperTest {
    @Test
    public void givenResultSet_whenMapRow_thanAllRowsMappedCorrectly() throws SQLException {
        ResultSet mockResultSet = mock(ResultSet.class);

        when(mockResultSet.getInt("genre_id")).thenReturn(1);
        when(mockResultSet.getString("name")).thenReturn("name");

        GenreRowMapper genreRowMapper = new GenreRowMapper();
        Genre genre = genreRowMapper.mapRow(mockResultSet, 0);

        assertEquals(1, genre.getGenreId());
        assertEquals("name", genre.getName());
    }
}
