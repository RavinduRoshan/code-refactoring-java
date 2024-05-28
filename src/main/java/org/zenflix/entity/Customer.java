package org.zenflix.entity;

import java.util.List;

/**
 * Represents a customer with a name and a list of movie rentals.
 *
 * @param name     the name of the customer
 * @param rentals  the list of movie rentals associated with the customer
 */
public record Customer(String name, List<MovieRental> rentals) {
}
