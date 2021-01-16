package com.movieapi.movieapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class MovieDetails {
    @Id
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    private Movie movie;
    private int averageRating;
    @ElementCollection(targetClass = Integer.class)
    private List<Integer> rating;
    @ElementCollection(targetClass = String.class)
    private List<String> texts;

    public MovieDetails() {
        this.rating = new ArrayList<>();
        this.texts = new ArrayList<>();
    }

    public static List<Integer> getRatings(String title) {
        return new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public List<Integer> getRating() {
        return rating;
    }

    public void setRating(List<Integer> rating) {
        this.rating = rating;
    }

    public List<String> getTexts() {
        return texts;
    }

    public void setTexts(List<String> texts) {
        this.texts = texts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDetails that = (MovieDetails) o;
        return averageRating == that.averageRating && Objects.equals(title, that.title) && Objects.equals(movie, that.movie) && Objects.equals(rating, that.rating) && Objects.equals(texts, that.texts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, movie, averageRating, rating, texts);
    }

}
