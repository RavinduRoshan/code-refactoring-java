package org.zenflix.util;

import org.junit.jupiter.api.Test;
import org.zenflix.constants.MovieType;
import org.zenflix.service.PricingStrategy;
import org.zenflix.service.impl.ChildrenPricingStrategy;
import org.zenflix.service.impl.NewReleasePricingStrategy;
import org.zenflix.service.impl.RegularPricingStrategy;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PricingStrategyFactoryTest {

    /**
     * Tests that the factory returns a {@link RegularPricingStrategy} for {@link MovieType#REGULAR}.
     */
    @Test
    public void testGetPricingStrategyForRegular() {
        PricingStrategy strategy = PricingStrategyFactory.getPricingStrategy(MovieType.REGULAR);
        assertTrue(strategy instanceof RegularPricingStrategy, "Expected instance of RegularPricingStrategy");
    }

    /**
     * Tests that the factory returns a {@link ChildrenPricingStrategy} for {@link MovieType#CHILDREN}.
     */
    @Test
    public void testGetPricingStrategyForChildren() {
        PricingStrategy strategy = PricingStrategyFactory.getPricingStrategy(MovieType.CHILDREN);
        assertTrue(strategy instanceof ChildrenPricingStrategy, "Expected instance of ChildrenPricingStrategy");
    }

    /**
     * Tests that the factory returns a {@link NewReleasePricingStrategy} for {@link MovieType#NEW_RELEASE}.
     */
    @Test
    public void testGetPricingStrategyForNewRelease() {
        PricingStrategy strategy = PricingStrategyFactory.getPricingStrategy(MovieType.NEW_RELEASE);
        assertTrue(strategy instanceof NewReleasePricingStrategy, "Expected instance of NewReleasePricingStrategy");
    }
}