package com.mykovolod.movieland.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml",
        "file:src/main/webapp/WEB-INF/applicationContext.xml",
        "classpath:applicationContextTest.xml"})
public class MovieControllerTest {

    @Value("${random.movies.limit}")
    private int limit;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
                .alwaysDo(print())
                .build();
    }


    @Test
    public void givenMovies_whenGetAll_thenMatch() throws Exception {

        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nameRussian").value("Побег из Шоушенка"))
                .andExpect(jsonPath("$[0].nameNative").value("The Shawshank Redemption"))
                .andExpect(jsonPath("$[0].description").doesNotExist())
                .andExpect(jsonPath("$[0].yearOfRelease").value("1994"))
                .andExpect(jsonPath("$[0].rating").value(8.90))
                .andExpect(jsonPath("$[0].price").value(123.45))
                .andExpect(jsonPath("$[0].picturePath").value("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nameRussian").value("Зеленая миля"))
                .andExpect(jsonPath("$[1].nameNative").value("The Green Mile"))
                .andExpect(jsonPath("$[1].description").doesNotExist())
                .andExpect(jsonPath("$[1].yearOfRelease").value("1999"))
                .andExpect(jsonPath("$[1].rating").value(8.88))
                .andExpect(jsonPath("$[1].price").value(134.67))
                .andExpect(jsonPath("$[1].picturePath").value("https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg"));

    }

    @Test
    public void givenMovies_whenGetRandom_thenReturnByLimit() throws Exception {

        mockMvc.perform(get("/movie/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(limit)));
    }

    @Test
    public void givenMovies_whenGetByGenre_thenReturnOnlyWithSelectedGenre() throws Exception {

        mockMvc.perform(get("/movie/genre/4"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nameRussian").value("Побег из Шоушенка"))
                .andExpect(jsonPath("$[0].nameNative").value("The Shawshank Redemption"))
                .andExpect(jsonPath("$[0].description").doesNotExist())
                .andExpect(jsonPath("$[0].yearOfRelease").value("1994"))
                .andExpect(jsonPath("$[0].rating").value(8.90))
                .andExpect(jsonPath("$[0].price").value(123.45))
                .andExpect(jsonPath("$[0].picturePath").value("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg"))
                .andExpect(jsonPath("$[1].id").value(3))
                .andExpect(jsonPath("$[1].nameRussian").value("Форрест Гамп"))
                .andExpect(jsonPath("$[1].nameNative").value("Forrest Gump"))
                .andExpect(jsonPath("$[1].description").doesNotExist())
                .andExpect(jsonPath("$[1].yearOfRelease").value("1994"))
                .andExpect(jsonPath("$[1].rating").value(8.6))
                .andExpect(jsonPath("$[1].price").value(200.6))
                .andExpect(jsonPath("$[1].picturePath").value("https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BaFgfdgfdnBnXkFtZTYwOTU2NTY3._V1._09_.jpg"));

    }

    @Test
    public void givenMovies_whenGetByNotExistingGenre_thenNoDataFound() throws Exception {

        mockMvc.perform(get("/movie/genre/-1"))
                .andExpect(jsonPath("$", hasSize(0)))
                .andExpect(status().isOk());
    }

}
