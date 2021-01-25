package com.thomasdomingues.videostore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void rent(Movie movie, int daysRented) {
        Rental newRental = new Rental(movie, daysRented);
        rentals.add(newRental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            double rentalPrice = rental.getPrice();
            frequentRenterPoints += rental.getEarnedFrequentRenterPoints();

            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(rental) + "\n";
            totalAmount += rentalPrice;

        }

        result += "You owed " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";


        return result;
    }
}