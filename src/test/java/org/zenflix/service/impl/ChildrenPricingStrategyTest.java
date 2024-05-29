package org.zenflix.service.impl;

import org.junit.jupiter.api.Test;
import org.zenflix.service.PricingStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChildrenPricingStrategyTest {
    private final PricingStrategy pricingStrategy = new ChildrenPricingStrategy();

    /**
     * Tests the calculation of the price for a rental period less than or equal to the maximum days for default price.
     */
    @Test
    public void testCalculatePrice_WithDefaultPricePeriod() {
        int days = 3; // MAX_DAYS_FOR_DEFAULT_PRICE
        double expectedPrice = 1.5; // DEFAULT_PRICE
        double actualPrice = pricingStrategy.calculatePrice(days);
        assertEquals(expectedPrice, actualPrice, "The price for up to 3 days should be the default price.");
    }

    /**
     * Tests the calculation of the price for a rental period greater than the maximum days for default price.
     */
    @Test
    public void testCalculatePrice_WithAdditionalDays() {
        int days = 4;
        double expectedPrice = 1.5 + (4 - 3) * 1.5; // DEFAULT_PRICE + (extra days * PRICE_PER_DAY)
        double actualPrice = pricingStrategy.calculatePrice(days);
        assertEquals(expectedPrice, actualPrice,
                "The price for 4 days should be the default price plus additional charges.");
    }

    /**
     * Tests the calculation of the price for a rental period of 0 days.
     */
    @Test
    public void testCalculatePrice_WithZeroDays() {
        int days = 0;
        double expectedPrice = 0.0;
        double actualPrice = pricingStrategy.calculatePrice(days);
        assertEquals(expectedPrice, actualPrice, "The price for 0 days should be 0.");
    }

    /**
     * Tests the calculation of the price for a rental period of 1 day.
     */
    @Test
    public void testCalculatePrice_WithOneDay() {
        int days = 1;
        double expectedPrice = 1.5; // DEFAULT_PRICE
        double actualPrice = pricingStrategy.calculatePrice(days);
        assertEquals(expectedPrice, actualPrice, "The price for 1 day should be the default price.");
    }
}