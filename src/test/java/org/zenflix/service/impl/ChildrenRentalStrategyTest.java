package org.zenflix.service.impl;

import org.junit.jupiter.api.Test;
import org.zenflix.service.RentalStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChildrenRentalStrategyTest {
    private final RentalStrategy rentalStrategy = ChildrenRentalStrategy.getInstance();

    /**
     * Tests the calculation of the price for a rental period less than or equal to the maximum days for default price.
     */
    @Test
    public void testCalculatePrice_WithDefaultPricePeriod() {
        int days = 3; // MAX_DAYS_FOR_DEFAULT_PRICE
        double expectedPrice = 1.5; // DEFAULT_PRICE
        double actualPrice = rentalStrategy.calculatePrice(days);
        assertEquals(expectedPrice, actualPrice, "The price for up to 3 days should be the default price.");
    }

    /**
     * Tests the calculation of the price for a rental period greater than the maximum days for default price.
     */
    @Test
    public void testCalculatePrice_WithAdditionalDays() {
        int days = 4;
        double expectedPrice = 1.5 + (4 - 3) * 1.5; // DEFAULT_PRICE + (extra days * PRICE_PER_DAY)
        double actualPrice = rentalStrategy.calculatePrice(days);
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
        double actualPrice = rentalStrategy.calculatePrice(days);
        assertEquals(expectedPrice, actualPrice, "The price for 0 days should be 0.");
    }

    /**
     * Tests the calculation of the price for a rental period of 1 day.
     */
    @Test
    public void testCalculatePrice_WithOneDay() {
        int days = 1;
        double expectedPrice = 1.5; // DEFAULT_PRICE
        double actualPrice = rentalStrategy.calculatePrice(days);
        assertEquals(expectedPrice, actualPrice, "The price for 1 day should be the default price.");
    }

    /**
     * Tests that the method returns 0 points for zero rental days.
     */
    @Test
    public void testGeneratePoints_ZeroDays() {
        int days = 0;
        int points = rentalStrategy.generatePoints(days);
        assertEquals(0, points, "Points should be 0 for zero rental days");
    }

    /**
     * Tests that the method returns 0 points for negative rental days.
     */
    @Test
    public void testGeneratePoints_NegativeDays() {
        int days = -1;
        int points = rentalStrategy.generatePoints(days);
        assertEquals(0, points, "Points should be 0 for negative rental days");
    }

    /**
     * Tests that the method returns 1 point for one rental day.
     */
    @Test
    public void testGeneratePoints_OneDay() {
        int days = 1;
        int points = rentalStrategy.generatePoints(days);
        assertEquals(1, points, "Points should be 1 for one rental day");
    }

    /**
     * Tests that the method returns 1 point for two rental days.
     */
    @Test
    public void testGeneratePoints_TwoDays() {
        int days = 2;
        int points = rentalStrategy.generatePoints(days);
        assertEquals(1, points, "Points should be 1 for two rental days");
    }

    /**
     * Tests that the method returns 1 points for three rental days.
     */
    @Test
    public void testGeneratePoints_ThreeDays() {
        int days = 3;
        int points = rentalStrategy.generatePoints(days);
        assertEquals(1, points, "Points should be 1 for three rental days");
    }

    /**
     * Tests that the method returns 1 points for four rental days.
     */
    @Test
    public void testGeneratePoints_FourDays() {
        int days = 4;
        int points = rentalStrategy.generatePoints(days);
        assertEquals(1, points, "Points should be 1 for four rental days");
    }
}