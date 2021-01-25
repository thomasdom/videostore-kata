package com.thomasdomingues.videostore;

public class Rental {
    private static final int STANDARD_FREQUENT_RENTER_POINTS_EARNED = 1;
    private static final int BONUS_FREQUENT_RENTER_POINTS = 1;

    private final Movie movie;
    private final int daysRented;
    private final RentalPricingStrategy pricingStrategy;

    public Rental(Movie movie, int daysRented, RentalPricingStrategy pricingStrategy) {
        this.movie = movie;
        this.daysRented = daysRented;
        this.pricingStrategy = pricingStrategy;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getPrice() {
        return pricingStrategy.calculatePricing(getDaysRented());
    }

    public int getEarnedFrequentRenterPoints() {
        int earnedFrequentRenterPoints = STANDARD_FREQUENT_RENTER_POINTS_EARNED;

        if (isEligibleForABonus()) {
            earnedFrequentRenterPoints += BONUS_FREQUENT_RENTER_POINTS;
        }

        return earnedFrequentRenterPoints;
    }

    private boolean isEligibleForABonus() {
        return this.getMovie().getPriceCode() == PriceCode.NEW_RELEASE && this.getDaysRented() > 1;
    }
}