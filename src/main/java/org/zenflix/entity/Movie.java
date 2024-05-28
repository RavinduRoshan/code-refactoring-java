package org.zenflix.entity;

import org.zenflix.constants.MovieType;


/**
 * Represents a movie with an ID, title, and type.
 *
 * @param id    the unique identifier of the movie
 * @param title the title of the movie
 * @param type  the type of the movie (e.g., REGULAR, CHILDREN, NEW_RELEASE)
 */
public record Movie (String id, String title, MovieType type) {
}
