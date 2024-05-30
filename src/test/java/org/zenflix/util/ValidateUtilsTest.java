package org.zenflix.util;

import org.junit.jupiter.api.Test;
import org.zenflix.entity.Customer;
import org.zenflix.entity.MovieRental;
import org.zenflix.exception.InvalidCustomerException;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidateUtilsTest {

    @Test
    void validateCustomer_NullCustomer_ThrowsInvalidCustomerException() {
        assertThrows(InvalidCustomerException.class, () -> ValidateUtils.validateCustomer(null));
    }

    @Test
    void validateCustomer_NullName_ThrowsInvalidCustomerException() {
        Customer customer = new Customer(null, Collections.emptyList());
        assertThrows(InvalidCustomerException.class, () -> ValidateUtils.validateCustomer(customer));
    }

    @Test
    void validateCustomer_EmptyName_ThrowsInvalidCustomerException() {
        Customer customer = new Customer("", Collections.emptyList());
        assertThrows(InvalidCustomerException.class, () -> ValidateUtils.validateCustomer(customer));
    }

    @Test
    void validateCustomer_NullRentalsList_ThrowsInvalidCustomerException() {
        Customer customer = new Customer("John Doe", null);
        assertThrows(InvalidCustomerException.class, () -> ValidateUtils.validateCustomer(customer));
    }

    @Test
    void validateCustomer_NullRentalInRentalsList_ThrowsInvalidCustomerException() {
        List<MovieRental> rentals = Collections.singletonList(null);
        Customer customer = new Customer("John Doe", rentals);
        assertThrows(InvalidCustomerException.class, () -> ValidateUtils.validateCustomer(customer));
    }

    @Test
    void validateCustomer_ValidCustomer_NoExceptionThrown() {
        List<MovieRental> rentals = Collections.emptyList();
        Customer customer = new Customer("John Doe", rentals);
        assertDoesNotThrow(() -> ValidateUtils.validateCustomer(customer));
    }
}