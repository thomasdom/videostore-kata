package com.thomasdomingues.videostore;

public class NewReleasePricing implements RentalPricingStrategy {
    @Override
    public double calculatePricing(int daysRented) {
        return daysRented * 3;
    }
}
