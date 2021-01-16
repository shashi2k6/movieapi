package com.movieapi.movieapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class MovieControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;


    @Test
    public void test_getAllMovieList() throws Exception {
        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*",hasSize(7)))
        ;
    }

    @Test
    public  void test_getMovieByTitle() throws Exception {
        mockMvc.perform(get("/movie/Steel"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.director").value("Kenneth Johnson"))
                .andExpect(jsonPath("$.release").value("1997"))
        ;
    }
    @Test
    public  void test_getMovieByTitle_doesNotExist() throws Exception {
        mockMvc.perform(get("/movie/Steels"))
                .andExpect(status().isNotFound())

        ;
    }


}
