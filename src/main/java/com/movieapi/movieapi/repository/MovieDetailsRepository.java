package com.movieapi.movieapi.repository;

import com.movieapi.movieapi.model.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetails, String> {
}