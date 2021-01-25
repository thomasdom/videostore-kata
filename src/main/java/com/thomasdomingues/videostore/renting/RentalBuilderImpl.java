package com.thomasdomingues.videostore.renting;

import com.thomasdomingues.videostore.Movie;
import com.thomasdomingues.videostore.Rental;
import com.thomasdomingues.videostore.pricing.ChildrenPricing;
import com.thomasdomingues.videostore.pricing.NewReleasePricing;
import com.thomasdomingues.videostore.pricing.RegularMoviePricing;
import com.thomasdomingues.videostore.pricing.RentalPricingStrategy;

public class RentalBuilderImpl implements RentalBuilder {
    private Movie movie;
    private int daysRented;

    @Override
    public RentalBuilder forMovie(Movie movie) {
        this.movie = movie;

        return this;
    }

    @Override
    public RentalBuilder withRentedDuration(int daysRented) {
        this.daysRented = daysRented;

        return this;
    }

    @Override
    public Rental build() {
        if (movie == null) {
            throw new IllegalStateException("You must define a movie to rent");
        }

        if (daysRented <= 0) {
            throw new IllegalStateException("Rented days must be a positive integer");
        }

        RentalPricingStrategy pricingStrategy = null;
        switch (movie.getPriceCode()) {
            case REGULAR:
                pricingStrategy = new RegularMoviePricing(daysRented);
                break;
            case NEW_RELEASE:
                pricingStrategy = new NewReleasePricing(daysRented);
                break;
            case CHILDREN:
                pricingStrategy = new ChildrenPricing(daysRented);
                break;
        }

        return new Rental(movie, daysRented, pricingStrategy);
    }
}
