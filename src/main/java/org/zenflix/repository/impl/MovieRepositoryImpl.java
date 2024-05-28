package org.zenflix.repository.impl;

import org.zenflix.constants.MovieType;
import org.zenflix.entity.Movie;
import org.zenflix.repository.MovieRepository;

import java.util.HashMap;
import java.util.Map;

public class MovieRepositoryImpl implements MovieRepository {
    private final Map<String, Movie> movies = new HashMap<>();

    public MovieRepositoryImpl() {
        populateMovies();
    }

    @Override
    public Map<String, Movie> getAllMovies() {
        return this.movies;
    }

    @Override
    public Movie findById(String movieId) {
        return movies.get(movieId);
    }

    private void populateMovies() {
        this.movies.put("F001", new Movie("F001", "You've Got Mail", MovieType.REGULAR));
        this.movies.put("F002", new Movie("F002", "Matrix", MovieType.REGULAR));
        this.movies.put("F003", new Movie("F003", "Cars", MovieType.CHILDREN));
        this.movies.put("F004", new Movie("F004", "Fast & Furious X", MovieType.NEW_RELEASE));
    }
}
