package org.zenflix.service.impl;

import org.junit.jupiter.api.Test;
import org.zenflix.service.RentalStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewReleaseRentalStrategyTest {

    private final RentalStrategy rentalStrategy = new NewReleaseRentalStrategy();

    /**
     * Tests the calculation of the price for a rental period of 4 days.
     */
    @Test
    public void testCalculatePrice_WithAdditionalDays() {
        int days = 4;
        double expectedPrice = 4 * 3;
        double actualPrice = rentalStrategy.calculatePrice(days);
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
        double actualPrice = rentalStrategy.calculatePrice(days);
        assertEquals(expectedPrice, actualPrice, "The price for 0 days should be 0.");
    }

    /**
     * Tests the calculation of the price for a rental period of 1 day.
     */
    @Test
    public void testCalculatePrice_WithOneDay() {
        int days = 1;
        double expectedPrice = 3.0;
        double actualPrice = rentalStrategy.calculatePrice(days);
        assertEquals(expectedPrice, actualPrice, "The price for 1 day should be the price per day.");
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
     * Tests that the method returns 2 points for three rental days.
     */
    @Test
    public void testGeneratePoints_ThreeDays() {
        int days = 3;
        int points = rentalStrategy.generatePoints(days);
        assertEquals(2, points, "Points should be 2 for three rental days");
    }

    /**
     * Tests that the method returns 2 points for four rental days.
     */
    @Test
    public void testGeneratePoints_FourDays() {
        int days = 4;
        int points = rentalStrategy.generatePoints(days);
        assertEquals(2, points, "Points should be 2 for four rental days");
    }

    /**
     * Tests that the method returns 2 points for five rental days.
     */
    @Test
    public void testGeneratePoints_FiveDays() {
        int days = 5;
        int points = rentalStrategy.generatePoints(days);
        assertEquals(2, points, "Points should be 2 for five rental days");
    }
}