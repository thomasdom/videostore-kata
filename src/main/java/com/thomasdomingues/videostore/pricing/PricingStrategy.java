package com.thomasdomingues.videostore.pricing;

public abstract class PricingStrategy implements RentalPricingStrategy {
    protected final int daysRented;
    protected final double basePrice;

    public PricingStrategy(int daysRented, double basePrice) {
        this.daysRented = daysRented;
        this.basePrice = basePrice;
    }

    @Override
    public double calculatePricing() {
        return daysRented * basePrice;
    }
}
