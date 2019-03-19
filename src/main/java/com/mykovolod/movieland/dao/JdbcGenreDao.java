package com.mykovolod.movieland.dao;

import com.mykovolod.movieland.model.Genre;

import java.util.List;

public interface JdbcGenreDao {
    List<Genre> getAll();
}
