package org.zenflix.repository;

import org.zenflix.entity.Movie;

import java.util.Map;

public interface MovieRepository {
    Map<String, Movie> getAllMovies();

    Movie findById(String movieId);
}
