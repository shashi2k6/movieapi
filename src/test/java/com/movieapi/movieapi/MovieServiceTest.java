package com.movieapi.movieapi;

import com.movieapi.movieapi.exception.GenericNotFoundException;
import com.movieapi.movieapi.model.Movie;
import com.movieapi.movieapi.model.MovieDetails;
import com.movieapi.movieapi.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.transaction.Transactional;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    /**
     * Test to see a list of all movies
     * @throws IOException
     */
    @Test
    void test_getMovieList_equalsListSize() throws IOException {
        assertEquals(7,movieService.getMovies().size());
    }

    /**
     * Test to get all the movies.
     * @throws IOException
     */
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

    /**
     * Test to get movie by title.
     * @throws IOException
     */
    @Test
    void test_getMovieByTitle() throws IOException, GenericNotFoundException {
        Movie movie = new Movie();
        movie.setTitle("Steel");
        movie.setDirector("Kenneth Johnson");
        movie.setActors("Shaquille O'Neal, Annabeth Gish, Judd Nelson, Richard Roundtree");
        movie.setRelease("1997");
        movie.setDescription("A scientist for the military turns himself into a cartoon-like superhero when a version of one of his own weapons is being used against enemies.");
        movie.setRating(null);
        assertEquals(movie,movieService.getMovieByTitle("Steel"));
    }

    /**
     * Test to update movie rating.
     * @throws IOException
     */
    @Test
    void test_updateMovieRating() throws IOException, GenericNotFoundException {
        MovieDetails movie = movieService.updateMovieRating("Unbreakable", 5 , "bad movie");
        assertEquals(5, movie.getAverageRating());
        movie = movieService.updateMovieRating("Unbreakable", 3, "bad movie");
        assertEquals(4, movie.getAverageRating());
    }
    @Test
    void test_seeMovieDetailsWhenISubmitRating() throws IOException, GenericNotFoundException {
        MovieDetails  movie = movieService.updateMovieRating("Unbreakable", 5, "bad movie");
        assertEquals(5, movie.getAverageRating());
        assertEquals(1, movie.getRating().size());

    }
}
