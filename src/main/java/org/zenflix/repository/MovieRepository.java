package org.zenflix.repository;

import org.zenflix.entity.Movie;

import java.util.Map;

/**
 * Repository interface for accessing movie data.
 */
public interface MovieRepository {

    /**
     * Retrieves all movies from the repository.
     *
     * @return a map of movie IDs to movie objects
     */
    Map<String, Movie> getAllMovies();

    /**
     * Finds a movie by its ID.
     *
     * @param movieId the ID of the movie to find
     * @return the movie with the given ID, or {@code null} if no such movie exists
     */
    Movie findById(String movieId);
}
