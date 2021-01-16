package com.movieapi.movieapi.controller;

import com.movieapi.movieapi.exception.GenericNotFoundException;
import com.movieapi.movieapi.exception.MissingServletRequestParameterException;
import com.movieapi.movieapi.model.Movie;
import com.movieapi.movieapi.model.MovieDetails;
import com.movieapi.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping()
    public List<Movie> getMovieList() throws IOException {
        return movieService.getMovies();
    }

    @GetMapping("/{title}")
    public Movie getMovieList(@PathVariable String title) throws IOException, GenericNotFoundException {
        return movieService.getMovieByTitle(title);
    }

    @PatchMapping()
    public MovieDetails updateMovieRating(@RequestParam String title, @RequestParam String rating, @RequestParam String text) throws MissingServletRequestParameterException, IOException, GenericNotFoundException {
        if(rating == null || rating.equals("")){
        throw new MissingServletRequestParameterException("Star Rating is required");
        }

        return movieService.updateMovieRating(title,Integer.parseInt(rating), text);
    }


}
