package com.movieapi.movieapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieapi.movieapi.model.Movie;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    public List<Movie> getMovies() throws IOException {
        List movies = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        File movieFilePath = new File("src/main/java/com/movieapi/movieapi/data/movies.json");
        movies = mapper.readValue(movieFilePath, new TypeReference<List<Movie>>() {});
        return movies;
    }
}
