package com.mykovolod.movieland.service;

import com.mykovolod.movieland.dao.impl.CachedGenreDao;
import com.mykovolod.movieland.dao.impl.JdbcGenreDao;
import com.mykovolod.movieland.dao.GenreDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.atLeast;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml",
        "file:src/main/webapp/WEB-INF/applicationContext.xml",
        "classpath:defaultGenreServiceTest.xml",
})
public class DefaultGenreServiceTest {

    @Value("${genre.cache.retention.time}")
    private long cacheRetentionTime;
    @Autowired
    JdbcGenreDao jdbcGenreDao;
    @Autowired
    CachedGenreDao cachedGenreDao;
    @Autowired
    GenreService defaultGenreService;

    @Before
    public void initMocks() {
        when(jdbcGenreDao.getAll()).thenReturn(new ArrayList<>());
    }

    @Test
    public void givenCashedGenres_whenGetAll_thanReturnFromCache() {

        defaultGenreService.getAll();
//        defaultGenreService is expected to be called only once during init
        verify(jdbcGenreDao, times(1)).getAll();

    }

    @Test
    public void givenCacheRefreshedBySchedule_whenRetentionTimePassed_thanCacheRefreshed() throws InterruptedException {
        Thread.sleep(cacheRetentionTime * 3);

        verify(jdbcGenreDao, atLeast(2)).getAll();
    }

}
