package com.thomasdomingues.videostore.renting;

import com.thomasdomingues.videostore.Movie;
import com.thomasdomingues.videostore.Rental;

public interface RentalBuilder {
    public RentalBuilder forMovie(Movie movie);
    public RentalBuilder withRentedDuration(int daysRented);
    public Rental build() throws Exception;
}
