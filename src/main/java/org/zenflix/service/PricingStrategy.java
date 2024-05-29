package org.zenflix.service;

/**
 * Interface for calculating the price of a movie rental.
 */
public interface PricingStrategy {

    /**
     * Calculates the rental price for the movie based on the number of rental days.
     *
     * @param days the number of days the movie is rented for
     * @return the calculated rental price
     */
    double calculatePrice(int days);
}
