package com.mykovolod.movieland.service;

import com.mykovolod.movieland.dao.JdbcGenreDao;
import com.mykovolod.movieland.model.Genre;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultGenreService implements GenreService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final JdbcGenreDao cachedJdbcGenreDao;

    @Override
    public List<Genre> getAll() {
        List<Genre> genreDaoAll = cachedJdbcGenreDao.getAll();
        log.debug("Return genre: {}", genreDaoAll);
        return genreDaoAll;
    }
}
