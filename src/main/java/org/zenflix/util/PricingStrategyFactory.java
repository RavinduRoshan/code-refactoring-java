package org.zenflix.util;

import org.zenflix.constants.MovieType;
import org.zenflix.service.PricingStrategy;
import org.zenflix.service.impl.ChildrenPricingStrategy;
import org.zenflix.service.impl.NewReleasePricingStrategy;
import org.zenflix.service.impl.RegularPricingStrategy;

/**
 * Factory class for creating pricing strategies based on movie type.
 */
public class PricingStrategyFactory {

    /**
     * Returns a {@link PricingStrategy} instance based on the specified {@link MovieType}.
     *
     * @param type the type of the movie
     * @return the pricing strategy for the given movie type
     */
    public static PricingStrategy getPricingStrategy(MovieType type) {
        return switch (type) {
            case REGULAR -> new RegularPricingStrategy();
            case CHILDREN -> new ChildrenPricingStrategy();
            case NEW_RELEASE -> new NewReleasePricingStrategy();
        };
    }
}
