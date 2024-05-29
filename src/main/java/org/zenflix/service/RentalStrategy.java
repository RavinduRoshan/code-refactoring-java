package org.zenflix.service;

/**
 * Interface for calculating the price of a movie rental.
 */
public interface RentalStrategy {

    /**
     * Calculates the rental price for the movie based on the number of rental days.
     *
     * @param days the number of days the movie is rented for
     * @return the calculated rental price
     */
    double calculatePrice(int days);

    /**
     * Generates frequent renter points based on the number of rental days.
     * <p>
     * The method returns 1 point for any valid rental period (days > 0). If the rental period is zero or negative,
     * it returns 0 points.
     * </p>
     *
     * @param days the number of days the movie is rented
     * @return the number of frequent renter points earned
     */
    default int generatePoints(int days) {
        if (days <= 0) {
            return 0;
        }
        return 1;
    }
}
