package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter.departureUntilTheCurrentTime(flights);
        FlightFilter.findSegmentsWithArrivalDateBeforeDepartureDate(flights);
        FlightFilter.timeSpentOnTheGroundExceedsTwoHours(flights);
    }
}
