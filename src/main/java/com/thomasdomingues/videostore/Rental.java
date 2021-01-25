package com.thomasdomingues.videostore;

public class Rental {
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
}