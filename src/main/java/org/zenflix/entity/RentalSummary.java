package org.zenflix.entity;

/**
 * Represents a summary of a movie rental, including the total amount,
 * frequent renter points, and a formatted string of the title with the amount.
 *
 * @param totalAmount The total rental amount.
 * @param frequentEnterPoints The frequent renter points earned.
 * @param titlesWithAmount A formatted string combining the title and the amount.
 */
public record RentalSummary(double totalAmount, int frequentEnterPoints, String titlesWithAmount) {
}
