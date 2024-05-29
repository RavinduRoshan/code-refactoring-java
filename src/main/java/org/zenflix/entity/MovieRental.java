package org.zenflix.entity;

/**
 * Represents a rental of a movie, including the movie itself and the number of days it is rented for.
 *
 * @param movieId the movieId that is rented
 * @param days    the number of days the movie is rented for
 */
public record MovieRental(String movieId, int days) {
}
