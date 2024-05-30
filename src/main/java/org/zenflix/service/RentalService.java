package org.zenflix.service;

import org.zenflix.entity.Customer;

/**
 * The {@code RentalService} interface provides methods for managing customer rentals.
 * It includes functionality for generating rental summary statements for customers.
 */
public interface RentalService {

    /**
     * Generates a summary statement for the given customer.
     * The summary includes details such as the total amount owed and the frequent renter points earned.
     *
     * @param customer the customer for whom the summary statement is generated
     * @return the summary statement as a formatted string
     */
    String getSummaryStatement(Customer customer);
}
