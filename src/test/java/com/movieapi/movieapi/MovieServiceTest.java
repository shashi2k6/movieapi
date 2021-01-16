package com.movieapi.movieapi;

import com.movieapi.movieapi.model.Movie;
import com.movieapi.movieapi.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void test_getMovieList_equalsListSize() throws IOException {
        assertEquals(7,movieService.getMovies().size());
    }

    @Test
    void test_getMovieNames() throws IOException {
        assertEquals("The Avengers",movieService.getMovies().get(0).getTitle());
        assertEquals("Superman Returns",movieService.getMovies().get(1).getTitle());
        assertEquals("Steel",movieService.getMovies().get(2).getTitle());
        assertEquals("Unbreakable",movieService.getMovies().get(3).getTitle());
        assertEquals("Rocketeer",movieService.getMovies().get(4).getTitle());
        assertEquals("The Incredibles",movieService.getMovies().get(5).getTitle());
        assertEquals("The Lego Batman Movie",movieService.getMovies().get(6).getTitle());
    }

    @Test
    void test_getMovieByTitle() throws IOException {
        Movie movie = new Movie();
        movie.setTitle("Steel");
        movie.setDirector("Kenneth Johnson");
        movie.setActors("Shaquille O'Neal, Annabeth Gish, Judd Nelson, Richard Roundtree");
        movie.setRelease("1997");
        movie.setDescription("A scientist for the military turns himself into a cartoon-like superhero when a version of one of his own weapons is being used against enemies.");
        movie.setRating(null);

        assertEquals(movie,movieService.getMovieByTitle("Steel"));
    }
}
