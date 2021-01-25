package com.thomasdomingues.videostore;

public class ChildrenPricing implements RentalPricingStrategy {
    @Override
    public double calculatePricing(int daysRented) {
        double rentalPrice = 1.5;
        if (daysRented > 3) {
            rentalPrice += (daysRented - 3) * 1.5;
        }

        return rentalPrice;
    }
}
