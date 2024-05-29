package org.zenflix.service.impl;

import org.zenflix.constants.MovieType;
import org.zenflix.entity.Customer;
import org.zenflix.entity.Movie;
import org.zenflix.entity.MovieRental;
import org.zenflix.repository.MovieRepository;
import org.zenflix.service.RentalService;

import java.util.Map;

public class RentalServiceImpl implements RentalService {
    private final MovieRepository movieRepository;

    public RentalServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public String getSummaryStatement(Customer customer) {
        Map<String, Movie> movies = movieRepository.getAllMovies();

        double totalAmount = 0;
        int frequentEnterPoints = 0;
        String result = "Rental Record for " + customer.name() + "\n";
        for (MovieRental rental : customer.rentals()) {
            double thisAmount = 0;

            // determine amount for each movie
            if (MovieType.REGULAR.equals(movies.get(rental.movie().id()).type())) {
                thisAmount = 2;
                if (rental.days() > 2) {
                    thisAmount = ((rental.days() - 2) * 1.5) + thisAmount;
                }
            }
            if (MovieType.NEW_RELEASE.equals(movies.get(rental.movie().id()).type())) {
                thisAmount = rental.days() * 3;
            }
            if (MovieType.CHILDREN.equals(movies.get(rental.movie().id()).type())) {
                thisAmount = 1.5;
                if (rental.days() > 3) {
                    thisAmount = ((rental.days() - 3) * 1.5) + thisAmount;
                }
            }

            //add frequent bonus points
            frequentEnterPoints++;
            // add bonus for a two day new release rental
            if (MovieType.NEW_RELEASE.equals(movies.get(rental.movie().id()).type()) && rental.days() > 2) frequentEnterPoints++;

            //print figures for this rental
            result += "\t" + movies.get(rental.movie().id()).title() + "\t" + thisAmount + "\n";
            totalAmount = totalAmount + thisAmount;
        }
        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentEnterPoints + " frequent points\n";

        return result;
    }
}
