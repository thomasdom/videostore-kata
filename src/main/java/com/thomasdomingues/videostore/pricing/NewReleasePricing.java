package com.thomasdomingues.videostore.pricing;

public class NewReleasePricing extends PricingStrategy implements RentalPricingStrategy {
    private static final double BASE_PRICE = 3.0;

    public NewReleasePricing(int daysRented) {
        super(daysRented, BASE_PRICE);
    }

    // There is no maximum rent days for this type of movie
}
