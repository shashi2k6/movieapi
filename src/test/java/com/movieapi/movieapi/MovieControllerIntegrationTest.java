package com.movieapi.movieapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class MovieControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    /**
     * test to get all the movies from the data base
     * @throws Exception
     */
    @Test
    public void test_getAllMovieList() throws Exception {
        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*",hasSize(7)));
    }
    /**
     * test to get the  movie by title
     * @throws Exception
     */
    @Test
    public  void test_getMovieByTitle() throws Exception {
        mockMvc.perform(get("/movie/Steel"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.director").value("Kenneth Johnson"))
                .andExpect(jsonPath("$.release").value("1997"));
    }
    /**
     * test for if movie by title does not exist
     * @throws Exception
     */
    @Test
    public void test_getMovieByTitle_doesNotExist() throws Exception {
        mockMvc.perform(get("/movie/Steels"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Movie does not Exist"));
    }

    /**
     * test to update movie rating by title
     * @throws Exception
     */
    @Test
    public void test_updateMovieRatingByTitle() throws Exception {
        mockMvc.perform(patch("/movie")
                .param("title","Steel")
                .param("rating","5")
                .param("text","good movie"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Steel"))
                .andExpect(jsonPath("$.averageRating").value(5));
    }
}
