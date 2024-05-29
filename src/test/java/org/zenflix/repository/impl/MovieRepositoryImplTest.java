package org.zenflix.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zenflix.constants.MovieType;
import org.zenflix.entity.Movie;
import org.zenflix.repository.MovieRepository;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link MovieRepositoryImpl}.
 */
public class MovieRepositoryImplTest {
    private MovieRepository movieRepository;

    /**
     * Sets up the test environment before each test.
     * Initializes the {@link MovieRepositoryImpl} instance.
     */
    @BeforeEach
    void setUp() {
        movieRepository = new MovieRepositoryImpl();
    }

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