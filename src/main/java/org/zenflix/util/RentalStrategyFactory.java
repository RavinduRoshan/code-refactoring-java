package org.zenflix.util;

import org.zenflix.constants.MovieType;
import org.zenflix.service.RentalStrategy;
import org.zenflix.service.impl.ChildrenRentalStrategy;
import org.zenflix.service.impl.NewReleaseRentalStrategy;
import org.zenflix.service.impl.RegularRentalStrategy;

/**
 * Factory class for creating rental strategies based on movie type.
 */
public class RentalStrategyFactory {

    /**
     * Returns a {@link RentalStrategy} instance based on the specified {@link MovieType}.
     *
     * @param type the type of the movie
     * @return the rental strategy for the given movie type
     */
    public static RentalStrategy getRentalStrategy(MovieType type) {
        return switch (type) {
            case REGULAR -> new RegularRentalStrategy();
            case CHILDREN -> new ChildrenRentalStrategy();
            case NEW_RELEASE -> new NewReleaseRentalStrategy();
        };
    }
}
