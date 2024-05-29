package org.zenflix.util;

import org.junit.jupiter.api.Test;
import org.zenflix.constants.MovieType;
import org.zenflix.service.RentalStrategy;
import org.zenflix.service.impl.ChildrenRentalStrategy;
import org.zenflix.service.impl.NewReleaseRentalStrategy;
import org.zenflix.service.impl.RegularRentalStrategy;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RentalStrategyFactoryTest {

    /**
     * Tests that the factory returns a {@link RegularRentalStrategy} for {@link MovieType#REGULAR}.
     */
    @Test
    public void testGetRentalStrategyForRegular() {
        RentalStrategy strategy = RentalStrategyFactory.getRentalStrategy(MovieType.REGULAR);
        assertTrue(strategy instanceof RegularRentalStrategy, "Expected instance of RegularRentalStrategy");
    }

    /**
     * Tests that the factory returns a {@link ChildrenRentalStrategy} for {@link MovieType#CHILDREN}.
     */
    @Test
    public void testGetRentalStrategyForChildren() {
        RentalStrategy strategy = RentalStrategyFactory.getRentalStrategy(MovieType.CHILDREN);
        assertTrue(strategy instanceof ChildrenRentalStrategy, "Expected instance of ChildrenRentalStrategy");
    }

    /**
     * Tests that the factory returns a {@link NewReleaseRentalStrategy} for {@link MovieType#NEW_RELEASE}.
     */
    @Test
    public void testGetRentalStrategyForNewRelease() {
        RentalStrategy strategy = RentalStrategyFactory.getRentalStrategy(MovieType.NEW_RELEASE);
        assertTrue(strategy instanceof NewReleaseRentalStrategy, "Expected instance of NewReleaseRentalStrategy");
    }
}