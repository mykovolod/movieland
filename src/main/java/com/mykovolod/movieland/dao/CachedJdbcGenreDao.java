package com.mykovolod.movieland.dao;

import com.mykovolod.movieland.model.Genre;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CachedJdbcGenreDao implements JdbcGenreDao {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final JdbcGenreDao defaultJdbcGenreDao;
    private List<Genre> genreCache;

    @Override
    public List<Genre> getAll() {
        return genreCache;
    }

    @Scheduled(fixedRateString = "${genre.cache.retention.time}", initialDelay = 1000)
    private void refreshGenreCache() {
        log.info("Refreshing genre cache");
        genreCache = defaultJdbcGenreDao.getAll();
    }

    @PostConstruct
    private void init() {
        refreshGenreCache();
    }
}