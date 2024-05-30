package org.zenflix;

import org.zenflix.entity.Customer;
import org.zenflix.entity.MovieRental;
import org.zenflix.repository.impl.MovieRepositoryImpl;
import org.zenflix.service.RentalService;
import org.zenflix.service.impl.RentalServiceImpl;

import java.util.Arrays;

public class RentalApp {
    private static final RentalService rentalService = new RentalServiceImpl(MovieRepositoryImpl.getInstance());

    public static void main(String[] args) {
        String expected = """
                Rental Record for C. U. Stomer
                	You've Got Mail	3.5
                	Matrix	2.0
                Amount owed is 5.5
                You earned 2 frequent points
                """;

        Customer customer = new Customer("C. U. Stomer",
                Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1)));
        String result = rentalService.getSummaryStatement(customer);

        if (!result.equals(expected)) {
            throw new AssertionError("Expected: "
                    + System.lineSeparator() + String.format(expected) + System.lineSeparator() + System.lineSeparator()
                    + "Got: " + System.lineSeparator() + result);
        }

        System.out.println("Success");
    }
}
