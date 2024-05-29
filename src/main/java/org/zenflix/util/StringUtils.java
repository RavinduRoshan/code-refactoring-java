package org.zenflix.util;

import org.zenflix.entity.RentalSummary;

public class StringUtils {

    private StringUtils() {
    }

    public static String buildStatement(String customerName, RentalSummary rentalSummary) {
        return "Rental Record for " +
                customerName +
                "\n" +
                rentalSummary.titlesWithAmount() +
                "Amount owed is " +
                rentalSummary.totalAmount() +
                "\n" +
                "You earned " +
                rentalSummary.frequentEnterPoints() +
                " frequent points\n";
    }
}
