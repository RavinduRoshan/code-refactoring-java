package org.zenflix.util;

import org.zenflix.entity.Customer;
import org.zenflix.entity.MovieRental;
import org.zenflix.exception.InvalidCustomerException;

import java.util.List;

public class ValidateUtils {

    /**
     * Validates the given {@link Customer} object.
     * <p>
     * This method checks that the customer's name is not null or empty,
     * and that the list of rentals is not null and contains valid {@link MovieRental} objects.
     * A valid {@link MovieRental} is one that is not null.
     * </p>
     *
     * @param customer the customer object to validate
     * @throws InvalidCustomerException if the customer is invalid
     */
    public static void validateCustomer(Customer customer) {
        if (customer == null) {
            throw new InvalidCustomerException("Customer cannot be null");
        }

        // Validate customer name
        String name = customer.name();
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidCustomerException("Customer name cannot be null or empty");
        }

        // Validate rentals list
        List<MovieRental> rentals = customer.rentals();
        if (rentals == null) {
            throw new InvalidCustomerException("Rentals list cannot be null");
        }

        for (MovieRental rental : rentals) {
            if (rental == null) {
                throw new InvalidCustomerException("Rental in the rentals list cannot be null");
            }
        }
    }
}
