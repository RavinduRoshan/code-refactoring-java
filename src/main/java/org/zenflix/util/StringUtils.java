package org.zenflix.util;

import org.zenflix.entity.RentalSummary;

import static org.zenflix.constants.Common.NEW_LINE;
import static org.zenflix.constants.Common.TAB;

/**
 * Utility class for building and formatting rental statements.
 * This class provides static methods to generate formatted strings for rental records.
 */
public class StringUtils {

    /**
     * Private constructor to prevent instantiation.
     * This class is not meant to be instantiated as it contains only static utility methods.
     */
    private StringUtils() {
    }

    /**
     * Builds a rental statement for a customer based on the provided rental summary.
     * The statement includes the customer's name, the list of rented movies with amounts,
     * the total amount owed, and the total frequent renter points earned.
     *
     * @param customerName  the name of the customer
     * @param rentalSummary the summary of the customer's rental, containing total amount, frequent renter points,
     *                      and titles with amounts
     * @return a formatted rental statement string
     */
    public static String buildStatement(String customerName, RentalSummary rentalSummary) {
        return "Rental Record for " +
                customerName +
                NEW_LINE +
                rentalSummary.titlesWithAmount() +
                "Amount owed is " +
                rentalSummary.totalAmount() +
                NEW_LINE +
                "You earned " +
                rentalSummary.frequentEnterPoints() +
                " frequent points" +
                NEW_LINE;
    }

    /**
     * Generates a formatted string containing the movie title and the amount for that movie.
     * The string is formatted with tabs and a new line character.
     *
     * @param movieTitle the title of the movie
     * @param amount     the rental amount for the movie
     * @return a formatted string with the movie title and amount
     */
    public static String getTitleWithAmount(String movieTitle, double amount) {
        return TAB + movieTitle + TAB + amount + NEW_LINE;
    }
}
