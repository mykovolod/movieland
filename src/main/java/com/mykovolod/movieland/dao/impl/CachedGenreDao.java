package com.mykovolod.movieland.dao.impl;

import com.mykovolod.movieland.dao.GenreDao;
import com.mykovolod.movieland.model.Genre;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Primary
@Repository
@RequiredArgsConstructor
public class CachedGenreDao implements GenreDao {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final GenreDao defaultJdbcGenreDao;
    private volatile List<Genre> genreCache;

    @Override
    public List<Genre> getAll() {
        return new ArrayList<>(genreCache);
    }

    @Scheduled(fixedRateString = "${genre.cache.retention.time}", initialDelayString = "${genre.cache.retention.time}")
    private void refreshGenreCache() {
        log.info("Refreshing genre cache");
        genreCache = defaultJdbcGenreDao.getAll();
    }

    @PostConstruct
    private void init() {
        refreshGenreCache();
    }
}