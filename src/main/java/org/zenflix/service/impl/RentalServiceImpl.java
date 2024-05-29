package org.zenflix.service.impl;

import org.zenflix.constants.MovieType;
import org.zenflix.entity.Customer;
import org.zenflix.entity.Movie;
import org.zenflix.entity.MovieRental;
import org.zenflix.entity.RentalSummary;
import org.zenflix.repository.MovieRepository;
import org.zenflix.service.RentalStrategy;
import org.zenflix.service.RentalService;
import org.zenflix.util.RentalStrategyFactory;
import org.zenflix.util.StringUtils;

import java.util.List;

public class RentalServiceImpl implements RentalService {
    private final MovieRepository movieRepository;

    public RentalServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public String getSummaryStatement(Customer customer) {
        RentalSummary rentalSummary = getRentalSummary(customer.rentals());
        return StringUtils.buildStatement(customer.name(), rentalSummary);
    }

    private RentalSummary getRentalSummary(List<MovieRental> rentals) {
        double totalAmount = 0;
        int frequentEnterPoints = 0;
        StringBuilder titlesWithAmount = new StringBuilder();

        for (MovieRental rental : rentals) {
            Movie movie = movieRepository.findById(rental.movieId());

            double thisAmount = calculateAmount(movie, rental);
            totalAmount += thisAmount;

            frequentEnterPoints += getFrequentEnterPoints(movie.type(), rental.days());

            titlesWithAmount.append("\t").append(movie.title()).append("\t").append(thisAmount).append("\n");

        }

        return new RentalSummary(totalAmount, frequentEnterPoints, titlesWithAmount.toString());
    }

    /**
     * Calculates the rental amount for a given movie rental.
     *
     * @param rental the movie rental
     * @param movie the movie
     * @return the rental amount
     */
    private double calculateAmount(Movie movie, MovieRental rental) {
        RentalStrategy rentalStrategy = RentalStrategyFactory.getRentalStrategy(movie.type());
        return rentalStrategy.calculatePrice(rental.days());
    }

    private int getFrequentEnterPoints(MovieType movieType, int days) {
        RentalStrategy rentalStrategy = RentalStrategyFactory.getRentalStrategy(movieType);
        return rentalStrategy.generatePoints(days);
    }
}
