package com.thomasdomingues.videostore;

public class Rental {
    private static final int STANDARD_FREQUENT_RENTER_POINTS_EARNED = 1;
    private static final int BONUS_FREQUENT_RENTER_POINTS = 1;

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getPrice() {
        double rentalPrice = 0.0;

        // determines the amount for each line
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalPrice += 2;
                if (this.getDaysRented() > 2)
                    rentalPrice += (this.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalPrice += this.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                rentalPrice += 1.5;
                if (this.getDaysRented() > 3)
                    rentalPrice += (this.getDaysRented() - 3) * 1.5;
                break;
        }

        return rentalPrice;
    }

    public int getEarnedFrequentRenterPoints() {
        int earnedFrequentRenterPoints = STANDARD_FREQUENT_RENTER_POINTS_EARNED;

        if (isEligibleForABonus()) {
            earnedFrequentRenterPoints += BONUS_FREQUENT_RENTER_POINTS;
        }

        return earnedFrequentRenterPoints;
    }

    private boolean isEligibleForABonus() {
        return this.getMovie().getPriceCode() == Movie.NEW_RELEASE && this.getDaysRented() > 1;
    }
}