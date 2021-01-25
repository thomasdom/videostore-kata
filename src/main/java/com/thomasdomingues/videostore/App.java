package com.thomasdomingues.videostore;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Customer customer = new Customer("Thomas");

        Movie harryPotter = new Movie("Harry Potter and the Sorcerer's Stone", PriceCode.CHILDREN);
        customer.rent(harryPotter, 2);

        System.out.println(customer.getRentalHistorySummary());

        Movie djangoUnchained = new Movie("Django Unchained", PriceCode.REGULAR);
        customer.rent(djangoUnchained, 15);

        System.out.println(customer.getRentalHistorySummary());

        Movie theRentalMovie = new Movie("The Rental (2021)", PriceCode.NEW_RELEASE);
        customer.rent(theRentalMovie, 3);

        System.out.println(customer.getRentalHistorySummary());
    }
}
