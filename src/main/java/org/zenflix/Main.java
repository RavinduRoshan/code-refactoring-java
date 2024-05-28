package org.zenflix;

import org.zenflix.constants.MovieType;
import org.zenflix.entity.Customer;
import org.zenflix.entity.Movie;
import org.zenflix.entity.MovieRental;
import org.zenflix.entity.RentalInfo;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";

    Movie movie1 = new Movie("F001", "", MovieType.REGULAR); // use repository to get the movie by id
    Movie movie2 = new Movie("F002", "", MovieType.REGULAR);
    String result = new RentalInfo()
            .statement(new Customer("C. U. Stomer",
                    Arrays.asList(new MovieRental(movie1, 3),
                            new MovieRental(movie2, 1))));

    if (!result.equals(expected)) {
      throw new AssertionError("Expected: " + System.lineSeparator() + String.format(expected) + System.lineSeparator() + System.lineSeparator() + "Got: " + System.lineSeparator() + result);
    }

    System.out.println("Success");
  }
}
