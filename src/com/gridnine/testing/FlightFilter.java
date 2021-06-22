package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class FlightFilter {

    public static void departureUntilTheCurrentTime(List<Flight> flights) {

        List<Flight> list = new ArrayList();
        for (Flight flight : flights) {
            for (Segment segment : flight.getSegments()) {
                if (LocalDateTime.now().isBefore(segment.getDepartureDate())) {
                    list.add(flight);
                    break;
                }
            }
        }

        System.out.println("1.Departure up to the current point in time");
        if(list.isEmpty()) {
            System.out.println("There are no such flights");
        }else {
            for (Flight s : list) {
                System.out.println(s);
            }
        }
    }
    public static void findSegmentsWithArrivalDateBeforeDepartureDate(List<Flight> flights) {
        List<Flight> list = new ArrayList<>();
        flights.forEach(flight -> flight.getSegments()
                .stream()
                .filter(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())).limit(1)
                .forEach(segment -> list.add(flight)));

        System.out.println("2.Flights with arrival date earlier than departure date");
        if(list.isEmpty()) {
            System.out.println("There are no such flights");
        }else {
            for (Flight s : list) {
                System.out.println(s);
            }
        }
    }

    public static void timeSpentOnTheGroundExceedsTwoHours(List<Flight> flights){
        List<Flight> list = new ArrayList<>();
        flights.forEach(flight -> {
            int size = flight.getSegments().size();
            if (size > 1) {
                int hoursCount = 0;
                for (int i = 1; i < size; i++) {
                    hoursCount += ChronoUnit.HOURS.between(flight.getSegments().get(i - 1).getArrivalDate()
                            ,flight.getSegments().get(i).getDepartureDate());
                }
                if (hoursCount <= 2) {
                    list.add(flight);
                }
            } else {
                list.add(flight);
            }
        });

        System.out.println("3.Flight where the total time spent on the ground exceeds two hours");
        if(list.isEmpty()) {
            System.out.println("There are no such flights");
        }else {
            for (Flight s : list) {
                System.out.println(s);
            }
        }
    }
}
