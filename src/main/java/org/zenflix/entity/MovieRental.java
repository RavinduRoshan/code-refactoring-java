package org.zenflix.entity;

/**
 * Represents a rental of a movie, including the movie itself and the number of days it is rented for.
 *
 * @param movie the movie that is rented
 * @param days  the number of days the movie is rented for
 */
public record MovieRental (Movie movie, int days) {
}
