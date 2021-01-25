package com.thomasdomingues.videostore;

public class RegularMoviePricing implements RentalPricingStrategy {
    @Override
    public double calculatePricing(int daysRented) {
        double rentalPrice = 2;
        if (daysRented > 2) {
            rentalPrice += (daysRented - 2) * 1.5;
        }

        return rentalPrice;
    }
}
