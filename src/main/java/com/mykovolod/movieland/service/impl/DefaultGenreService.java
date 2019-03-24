package com.mykovolod.movieland.service.impl;

import com.mykovolod.movieland.dao.GenreDao;
import com.mykovolod.movieland.model.Genre;
import com.mykovolod.movieland.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultGenreService implements GenreService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final GenreDao genreDao;

    @Override
    public List<Genre> getAll() {
        List<Genre> genreDaoAll = genreDao.getAll();
        log.debug("Return genre: {}", genreDaoAll);
        return genreDaoAll;
    }
}
