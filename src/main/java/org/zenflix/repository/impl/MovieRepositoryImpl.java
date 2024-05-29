package org.zenflix.repository.impl;

import org.zenflix.constants.MovieType;
import org.zenflix.entity.Movie;
import org.zenflix.repository.MovieRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the {@link MovieRepository} interface that uses an in-memory data structure to store movies.
 */
public class MovieRepositoryImpl implements MovieRepository {
    private final Map<String, Movie> movies = new HashMap<>();

    /**
     * Constructs a new {@code MovieRepositoryImpl} and populates it with a default set of movies.
     */
    public MovieRepositoryImpl() {
        populateMovies();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Retrieves all movies from the repository.
     *
     * @return a map of movie IDs to movie objects
     */
    @Override
    public Map<String, Movie> getAllMovies() {
        return this.movies;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Finds a movie by its ID.
     *
     * @param movieId the ID of the movie to find
     * @return the movie with the given ID, or {@code null} if no such movie exists
     */
    @Override
    public Movie findById(String movieId) {
        return movies.get(movieId);
    }

    /**
     * Populates the repository with a default set of movies.
     */
    private void populateMovies() {
        this.movies.put("F001", new Movie("F001", "You've Got Mail", MovieType.REGULAR));
        this.movies.put("F002", new Movie("F002", "Matrix", MovieType.REGULAR));
        this.movies.put("F003", new Movie("F003", "Cars", MovieType.CHILDREN));
        this.movies.put("F004", new Movie("F004", "Fast & Furious X", MovieType.NEW_RELEASE));
    }
}
