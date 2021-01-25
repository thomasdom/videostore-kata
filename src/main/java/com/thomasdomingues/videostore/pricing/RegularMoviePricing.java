package com.thomasdomingues.videostore.pricing;

public class RegularMoviePricing extends PricingStrategy implements RentalPricingStrategy {
    private static final int MAXIMUM_RENT_DAYS = 2;
    private static final double BASE_PRICE = 2.0;
    private static final double ADDITIONAL_PRICE_PER_DAY = 1.5;

    public RegularMoviePricing(int daysRented) {
        super(daysRented, BASE_PRICE);
    }

    @Override
    public double calculatePricing() {
        double rentalPrice = basePrice;
        if (hasExceededMaximumRentDays(daysRented)) {
            rentalPrice += (daysRented - MAXIMUM_RENT_DAYS) * ADDITIONAL_PRICE_PER_DAY;
        }

        return rentalPrice;
    }

    private boolean hasExceededMaximumRentDays(int daysRented) {
        return daysRented > MAXIMUM_RENT_DAYS;
    }
}
