package com.thomasdomingues.videostore;

import junit.framework.TestCase;

public class VideoStoreTest extends TestCase {
    private Customer customer;

    public VideoStoreTest(String name) {
        super(name);
    }

    protected void setUp() {
        customer = new Customer("Fred");
    }

    public void testSingleNewReleaseStatement() {
        customer.rent(new Movie("The Cell", PriceCode.NEW_RELEASE), 3);
        assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", customer.statement());
    }

    public void testDualNewReleaseStatement() {
        customer.rent(new Movie("The Cell", PriceCode.NEW_RELEASE), 3);
        customer.rent(new Movie("The Tiger Movie", PriceCode.NEW_RELEASE), 3);
        assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tiger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", customer.statement());
    }

    public void testSingleChildrenStatement() {
        customer.rent(new Movie("The Tiger Movie", PriceCode.CHILDREN), 3);
        assertEquals("Rental Record for Fred\n\tThe Tiger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", customer.statement());
    }

    public void testMultipleRegularStatement() {
        customer.rent(new Movie("Plan 9 from Outer Space", PriceCode.REGULAR), 1);
        customer.rent(new Movie("8 1/2", PriceCode.REGULAR), 2);
        customer.rent(new Movie("Eraserhead", PriceCode.REGULAR), 3);

        assertEquals("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", customer.statement());
    }
}