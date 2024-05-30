package org.zenflix.service.impl;

import org.zenflix.constants.MovieType;
import org.zenflix.entity.Customer;
import org.zenflix.entity.Movie;
import org.zenflix.entity.MovieRental;
import org.zenflix.entity.RentalSummary;
import org.zenflix.repository.MovieRepository;
import org.zenflix.service.RentalService;
import org.zenflix.service.RentalStrategy;
import org.zenflix.util.RentalStrategyFactory;
import org.zenflix.util.StringUtils;
import org.zenflix.util.ValidateUtils;

import java.util.List;

/**
 * Implementation of the {@link RentalService} interface.
 * This class provides services related to customer rentals,
 * such as generating rental summaries and calculating rental amounts.
 */
public class RentalServiceImpl implements RentalService {
    private final MovieRepository movieRepository;

    /**
     * Constructs a new {@code RentalServiceImpl} with the specified {@link MovieRepository}.
     *
     * @param movieRepository the movie repository used to retrieve movie information
     */
    public RentalServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Generates a summary statement for the given customer.
     * The summary includes the total amount owed and the frequent renter points earned.
     *
     * @param customer the customer for whom the summary statement is generated
     * @return the summary statement as a formatted string
     */
    @Override
    public String getSummaryStatement(Customer customer) {
        ValidateUtils.validateCustomer(customer);
        RentalSummary rentalSummary = getRentalSummary(customer.rentals());
        return StringUtils.buildStatement(customer.name(), rentalSummary);
    }

    /**
     * Generates a rental summary for the given list of movie rentals.
     * The summary includes the total amount owed, the frequent renter points earned,
     * and the titles with corresponding rental amounts.
     *
     * @param rentals the list of movie rentals
     * @return the rental summary
     */
    private RentalSummary getRentalSummary(List<MovieRental> rentals) {
        double totalAmount = 0;
        int frequentEnterPoints = 0;
        StringBuilder titlesWithAmount = new StringBuilder();

        for (MovieRental rental : rentals) {
            Movie movie = movieRepository.findById(rental.movieId());
            double thisAmount = calculateAmount(movie.type(), rental);
            totalAmount += thisAmount;
            frequentEnterPoints += getFrequentEnterPoints(movie.type(), rental.days());
            titlesWithAmount.append(StringUtils.getTitleWithAmount(movie.title(), thisAmount));
        }

        return new RentalSummary(totalAmount, frequentEnterPoints, titlesWithAmount.toString());
    }

    /**
     * Calculates the rental amount for a given movie rental based on its type.
     *
     * @param movieType the type of the movie
     * @param rental    the movie rental
     * @return the rental amount
     */
    private double calculateAmount(MovieType movieType, MovieRental rental) {
        RentalStrategy rentalStrategy = RentalStrategyFactory.getRentalStrategy(movieType);
        return rentalStrategy.calculatePrice(rental.days());
    }

    /**
     * Generates the frequent renter points for a given movie rental based on its type and rental days.
     *
     * @param movieType the type of the movie
     * @param days      the number of days the movie is rented for
     * @return the number of frequent renter points earned
     */
    private int getFrequentEnterPoints(MovieType movieType, int days) {
        RentalStrategy rentalStrategy = RentalStrategyFactory.getRentalStrategy(movieType);
        return rentalStrategy.generatePoints(days);
    }
}
