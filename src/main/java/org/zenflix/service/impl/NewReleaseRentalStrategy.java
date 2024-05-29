package org.zenflix.service.impl;

import org.zenflix.service.RentalStrategy;

/**
 * Rental strategy for new release movies.
 */
public class NewReleaseRentalStrategy implements RentalStrategy {
    private static final int PRICE_PER_DAY = 3;
    private static final int MIN_DAYS_FOR_EXTRA_POINT = 2;

    /**
     * Calculates the rental price for a new released movie based on the number of rental days.
     *
     * @param days the number of days the movie is rented for
     * @return the calculated rental price
     */
    @Override
    public double calculatePrice(int days) {
        return days * PRICE_PER_DAY;
    }

    /**
     * Generates frequent renter points based on the number of rental days.
     * <p>
     * This method returns 1 point for any valid rental period (days > 0). If the rental period is greater than
     * 2 days, an additional bonus point is awarded. If the rental period is zero or negative, it returns 0 points.
     * </p>
     *
     * @param days the number of days the movie is rented
     * @return the number of frequent renter points earned
     */
    @Override
    public int generatePoints(int days) {
        if (days <= 0) {
            return 0;
        }

        int frequentEnterPoints = 1;
        if (days > MIN_DAYS_FOR_EXTRA_POINT) {
            frequentEnterPoints++;
        }

        return frequentEnterPoints;
    }
}
