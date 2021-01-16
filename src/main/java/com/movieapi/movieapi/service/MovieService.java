package com.movieapi.movieapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieapi.movieapi.model.MovieDetails;
import com.movieapi.movieapi.repository.MovieDetailsRepository;
import com.movieapi.movieapi.repository.MovieRepository;
import com.movieapi.movieapi.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> movies;

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieDetailsRepository movieDetailsRepository;

    public MovieService(MovieRepository movieRepository, MovieDetailsRepository movieDetailsRepository ) throws IOException {
        this.movieRepository  = movieRepository;
        this.movieDetailsRepository = movieDetailsRepository;
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

    public MovieDetails updateMovieRating(String title, int movieRating, String textReview) throws IOException {
        Movie movie = getMovieByTitle(title);
        movie.setRating(movieRating);

         MovieDetails movieDetails = new MovieDetails();
         movieDetails.setMovie(movieRepository.save(movie));
         movieDetails.setTitle(movie.getTitle());
         movieDetails.setAverageRating(movie.getRating());
         List<String> texts = movieDetails.getTexts();
         texts.add(textReview);
         movieDetails.setTexts(texts);
        List<Integer> rating = movieDetails.getRating();
        rating.add(movieRating);
        movieDetails.setRating(rating);

        return movieDetailsRepository.save(movieDetails);

    }
}
