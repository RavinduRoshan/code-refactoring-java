package org.zenflix.util;

import org.zenflix.entity.RentalSummary;

import static org.zenflix.constants.Common.NEW_LINE;
import static org.zenflix.constants.Common.TAB;

public class StringUtils {

    private StringUtils() {
    }

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

    public static String getTitleWithAmount(String movieTitle, double amount) {
        return TAB + movieTitle + TAB + amount + NEW_LINE;
    }
}
