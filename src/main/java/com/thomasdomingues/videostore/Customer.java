package com.thomasdomingues.videostore;

import com.thomasdomingues.videostore.renting.RentalBuilderImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void rent(Movie movie, int daysRented) {
        try {
            Rental newRental = new RentalBuilderImpl()
                    .forMovie(movie)
                    .withRentedDuration(daysRented)
                    .build();
            rentals.add(newRental);
        } catch (Exception e) {
            System.err.printf("Could not rent a movie for customer: %s%n", e.getMessage());
        }
    }

    public String getRentalHistorySummary() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        for (Rental rental : rentals) {
            totalAmount += rental.getPrice();
            frequentRenterPoints += rental.getEarnedFrequentRenterPoints();
        }

        return generateRentalHistorySummary(totalAmount, frequentRenterPoints);
    }

    public String getName() {
        return name;
    }

    private String generateRentalHistorySummary(final double owedPrice, final int earnedFrequentRenterPoints) {
        // We do not use any locale in String.format to prevent app from localizing float values
        // In a good application though, the tests should adapt to the current locale
        StringBuilder rentalHistorySummary = new StringBuilder(String.format((Locale) null, "Rental Record for %s%n", getName()));

        for (Rental rental : rentals) {
            rentalHistorySummary.append(String.format((Locale) null, "\t%s\t%.1f%n", rental.getMovie().getTitle(), rental.getPrice()));
        }

        rentalHistorySummary.append(String.format((Locale) null, "You owed %.1f%n", owedPrice));
        rentalHistorySummary.append(String.format((Locale) null, "You earned %d frequent renter points%n", earnedFrequentRenterPoints));

        return rentalHistorySummary.toString();
    }
}