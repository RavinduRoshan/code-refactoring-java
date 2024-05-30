package org.zenflix.exception;

/**
 * Exception thrown when a {@link Customer} object is found to be invalid during validation.
 * <p>
 * This exception is used to indicate various validation failures such as:
 * <ul>
 *   <li>Null or empty customer name</li>
 *   <li>Null rentals list</li>
 *   <li>Null rental in the rentals list</li>
 * </ul>
 * </p>
 */
public class InvalidCustomerException extends RuntimeException {
    public InvalidCustomerException(String message) {
        super(message);
    }
}
