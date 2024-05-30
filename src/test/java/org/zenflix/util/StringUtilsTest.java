package org.zenflix.util;

import org.junit.jupiter.api.Test;
import org.zenflix.entity.RentalSummary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.zenflix.constants.Common.NEW_LINE;
import static org.zenflix.constants.Common.TAB;

class StringUtilsTest {

    /**
     * Test for {@link StringUtils#buildStatement(String, RentalSummary)}.
     * This test verifies that the method correctly builds a rental statement string
     * for a given customer name and rental summary.
     */
    @Test
    void testBuildStatement() {
        String customerName = "John Doe";
        RentalSummary rentalSummary = new RentalSummary(10.0, 5, "Movie1\t3.0\nMovie2\t7.0\n");

        String expected = "Rental Record for John Doe" + NEW_LINE +
                "Movie1\t3.0\nMovie2\t7.0\n" +
                "Amount owed is 10.0" + NEW_LINE +
                "You earned 5 frequent points" + NEW_LINE;

        String result = StringUtils.buildStatement(customerName, rentalSummary);
        assertEquals(expected, result);
    }

    /**
     * Test for {@link StringUtils#getTitleWithAmount(String, double)}.
     * This test verifies that the method correctly generates a formatted string containing the movie title and amount.
     */
    @Test
    void testGetTitleWithAmount() {
        String movieTitle = "Inception";
        double amount = 5.0;

        String expected = TAB + "Inception" + TAB + "5.0" + NEW_LINE;
        String result = StringUtils.getTitleWithAmount(movieTitle, amount);
        assertEquals(expected, result);
    }
}