package org.zenflix.service.impl;

import org.zenflix.service.PricingStrategy;

/**
 * Pricing strategy for regular movies.
 */
public class RegularPricingStrategy implements PricingStrategy {
    private static final double DEFAULT_PRICE = 2;
    private static final double PRICE_PER_DAY = 1.5;
    private static final int MAX_DAYS_FOR_DEFAULT_PRICE = 2;

    /**
     * Calculates the rental price for a regular movie based on the number of rental days.
     *
     * @param days the number of days the movie is rented for
     * @return the calculated rental price
     */
    @Override
    public double calculatePrice(int days) {
        if (days <= 0) {
            return 0;
        }

        double amount = DEFAULT_PRICE;
        if (days > MAX_DAYS_FOR_DEFAULT_PRICE) {
            amount += (days - MAX_DAYS_FOR_DEFAULT_PRICE) * PRICE_PER_DAY;
        }

        return amount;
    }
}
