package org.zenflix.service.impl;

import org.junit.jupiter.api.Test;
import org.zenflix.service.PricingStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewReleasePricingStrategyTest {

    private final PricingStrategy pricingStrategy = new NewReleasePricingStrategy();

    /**
     * Tests the calculation of the price for a rental period of 4 days.
     */
    @Test
    public void testCalculatePrice_WithAdditionalDays() {
        int days = 4;
        double expectedPrice = 4 * 3;
        double actualPrice = pricingStrategy.calculatePrice(days);
        assertEquals(expectedPrice, actualPrice,
                "The price for 4 days should be 12.");
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
        double expectedPrice = 3.0;
        double actualPrice = pricingStrategy.calculatePrice(days);
        assertEquals(expectedPrice, actualPrice, "The price for 1 day should be the price per day.");
    }
}