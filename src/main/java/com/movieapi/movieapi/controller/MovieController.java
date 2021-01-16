package com.movieapi.movieapi.controller;

import com.movieapi.movieapi.exception.GenericNotFoundException;
import com.movieapi.movieapi.model.Movie;
import com.movieapi.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping("/movie")
    public List<Movie> getMovieList() throws IOException {
        return movieService.getMovies();
    }

    @GetMapping("/movie/{title}")
    public Movie getMovieList(@PathVariable String title) throws IOException, GenericNotFoundException {
        return movieService.getMovieByTitle(title);
    }



}
