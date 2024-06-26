package org.zenflix.repository.impl;

import org.junit.jupiter.api.Test;
import org.zenflix.constants.MovieType;
import org.zenflix.entity.Movie;
import org.zenflix.repository.MovieRepository;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Unit tests for {@link MovieRepositoryImpl}.
 */
public class MovieRepositoryImplTest {
    private final MovieRepository movieRepository = MovieRepositoryImpl.getInstance();

    /**
     * Tests the {@link MovieRepositoryImpl#getAllMovies()} method.
     * Verifies that the repository contains all the expected movies.
     */
    @Test
    void testGetAllMovies() {
        Map<String, Movie> movies = movieRepository.getAllMovies();
        assertEquals(4, movies.size(), "There should be 4 movies in the repository");

        assertMovie(movies.get("F001"), "F001", "You've Got Mail", MovieType.REGULAR);
        assertMovie(movies.get("F002"), "F002", "Matrix", MovieType.REGULAR);
        assertMovie(movies.get("F003"), "F003", "Cars", MovieType.CHILDREN);
        assertMovie(movies.get("F004"), "F004", "Fast & Furious X", MovieType.NEW_RELEASE);
    }

    /**
     * Tests the {@link MovieRepositoryImpl#findById(String)} method.
     * Verifies that the correct movie is returned for an existing ID.
     */
    @Test
    void testFindById_existingMovie() {
        Movie movie = movieRepository.findById("F001");
        assertNotNull(movie, "Movie should not be null");
        assertMovie(movie, "F001", "You've Got Mail", MovieType.REGULAR);
    }

    /**
     * Tests the {@link MovieRepositoryImpl#findById(String)} method.
     * Verifies that {@code null} is returned for a non-existing ID.
     */
    @Test
    void testFindById_nonExistingMovie() {
        Movie movie = movieRepository.findById("F999");
        assertNull(movie, "Movie should be null for a non-existing ID");
    }

    /**
     * Helper method to assert the properties of a movie.
     *
     * @param movie         the movie to assert
     * @param expectedId    the expected ID of the movie
     * @param expectedTitle the expected title of the movie
     * @param expectedType  the expected type of the movie
     */
    private void assertMovie(Movie movie, String expectedId, String expectedTitle, MovieType expectedType) {
        assertEquals(expectedId, movie.id(), "Movie ID does not match");
        assertEquals(expectedTitle, movie.title(), "Movie title does not match");
        assertEquals(expectedType, movie.type(), "Movie type does not match");
    }
}