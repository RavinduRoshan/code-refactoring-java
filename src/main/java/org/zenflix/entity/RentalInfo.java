package org.zenflix.entity;

import org.zenflix.constants.MovieType;

import java.util.HashMap;

public class RentalInfo {

  public String statement(Customer customer) {
    HashMap<String, Movie> movies = new HashMap();
    movies.put("F001", new Movie("F001", "You've Got Mail", MovieType.REGULAR));
    movies.put("F002", new Movie("F002", "Matrix", MovieType.REGULAR));
    movies.put("F003", new Movie("F003", "Cars", MovieType.CHILDREN));
    movies.put("F004", new Movie("F004", "Fast & Furious X", MovieType.NEW_RELEASE));

    double totalAmount = 0;
    int frequentEnterPoints = 0;
    String result = "Rental Record for " + customer.getName() + "\n";
    for (MovieRental r : customer.getRentals()) {
      double thisAmount = 0;

      // determine amount for each movie
      if (movies.get(r.getMovieId()).type().equals(MovieType.REGULAR)) {
        thisAmount = 2;
        if (r.getDays() > 2) {
          thisAmount = ((r.getDays() - 2) * 1.5) + thisAmount;
        }
      }
      if (movies.get(r.getMovieId()).type().equals(MovieType.NEW_RELEASE)) {
        thisAmount = r.getDays() * 3;
      }
      if (movies.get(r.getMovieId()).type().equals(MovieType.CHILDREN)) {
        thisAmount = 1.5;
        if (r.getDays() > 3) {
          thisAmount = ((r.getDays() - 3) * 1.5) + thisAmount;
        }
      }

      //add frequent bonus points
      frequentEnterPoints++;
      // add bonus for a two day new release rental
      if (movies.get(r.getMovieId()).type().equals(MovieType.NEW_RELEASE) && r.getDays() > 2) frequentEnterPoints++;

      //print figures for this rental
      result += "\t" + movies.get(r.getMovieId()).title() + "\t" + thisAmount + "\n";
      totalAmount = totalAmount + thisAmount;
    }
    // add footer lines
    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentEnterPoints + " frequent points\n";

    return result;
  }
}
