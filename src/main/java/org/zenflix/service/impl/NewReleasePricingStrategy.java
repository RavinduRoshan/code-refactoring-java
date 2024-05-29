package org.zenflix.service.impl;

import org.zenflix.service.PricingStrategy;

/**
 * Pricing strategy for new release movies.
 */
public class NewReleasePricingStrategy implements PricingStrategy {
    private static final int PRICE_PER_DAY = 3;

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
}
