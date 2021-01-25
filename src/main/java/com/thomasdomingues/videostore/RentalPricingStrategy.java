package com.thomasdomingues.videostore;

public interface RentalPricingStrategy {
    double calculatePricing(int daysRented);
}
