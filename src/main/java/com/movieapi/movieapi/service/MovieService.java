package com.movieapi.movieapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieapi.movieapi.MovieRepository;
import com.movieapi.movieapi.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> movies;

    @Autowired
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) throws IOException {
        this.movieRepository  = movieRepository;
        movies = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        File movieFilePath = new File("src/main/java/com/movieapi/movieapi/data/movies.json");
        movies = mapper.readValue(movieFilePath, new TypeReference<List<Movie>>() {});

        for (Movie movie:movies) {
            movieRepository.save(movie);
        }
    }

    public List<Movie> getMovies() throws IOException {
        return movieRepository.findAll();
    }

    public Movie getMovieByTitle(String title) throws IOException {
        return movieRepository.findById(title).get();
    }

    public Movie updateMovieRating(String title,int movieRating) throws IOException {
        Movie movie = getMovieByTitle(title);
        movie.setRating(movieRating);
        return movieRepository.save(movie);
    }
}
