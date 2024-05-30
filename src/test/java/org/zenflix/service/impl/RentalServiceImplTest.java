package org.zenflix.service.impl;

import org.junit.jupiter.api.Test;
import org.zenflix.entity.Customer;
import org.zenflix.entity.MovieRental;
import org.zenflix.exception.InvalidCustomerException;
import org.zenflix.repository.impl.MovieRepositoryImpl;
import org.zenflix.service.RentalService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RentalServiceImplTest {
    private final RentalService rentalService = RentalServiceImpl.getInstance();

    @Test
    void getSummaryStatement_ValidCustomer_ReturnsSummary() {
        Customer customer = new Customer("John Doe", Arrays.asList(
                new MovieRental("F001", 3),
                new MovieRental("F002", 2)
        ));
        String summary = rentalService.getSummaryStatement(customer);

        String expected = """
                Rental Record for John Doe
                \tYou've Got Mail\t3.5
                \tMatrix\t2.0
                Amount owed is 5.5
                You earned 2 frequent points
                """;
        assertEquals(expected, summary);
    }

    @Test
    void getSummaryStatement_NullCustomer_ThrowsException() {
        assertThrows(InvalidCustomerException.class, () -> rentalService.getSummaryStatement(null));
    }
}