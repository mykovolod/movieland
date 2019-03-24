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

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml",
        "file:src/main/webapp/WEB-INF/applicationContext.xml",
        "classpath:webapp/applicationContextTest.xml"})
public class GenreControllerTest {

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

        mockMvc.perform(get("/genre"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(6)))
                .andExpect(jsonPath("$[*].id", containsInAnyOrder(1, 2, 3, 4, 5, 6)))
                .andExpect(jsonPath("$[*].name", containsInAnyOrder("драма", "криминал",
                        "детектив", "мелодрама", "биография", "комедия")))
        ;
    }

}
