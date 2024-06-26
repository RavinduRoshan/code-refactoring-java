package org.zenflix.service.impl;

import org.zenflix.service.RentalStrategy;

/**
 * Rental strategy for children's movies.
 */
public class ChildrenRentalStrategy implements RentalStrategy {
    private static final double DEFAULT_PRICE = 1.5;
    private static final double PRICE_PER_DAY = 1.5;
    private static final int MAX_DAYS_FOR_DEFAULT_PRICE = 3;

    // Private constructor to prevent instantiation
    private ChildrenRentalStrategy() {}

    /**
     * Singleton Holder class for lazy initialization.
     */
    private static class SingletonHolder {
        private static final ChildrenRentalStrategy INSTANCE = new ChildrenRentalStrategy();
    }

    /**
     * Provides the global point of access to the Singleton instance.
     *
     * @return the single instance of ChildrenRentalStrategy
     */
    public static ChildrenRentalStrategy getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Calculates the rental price for a children movie based on the number of rental days.
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
