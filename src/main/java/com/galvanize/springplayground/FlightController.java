package com.galvanize.springplayground;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @GetMapping("/flight")
    public ResponseEntity<Flight> getFlight() throws ParseException {
        Flight flight = new Flight(
                new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2017-04-21 14:34"),
                new ArrayList<Ticket>() {{
                    add(new Ticket(new Passenger("Some name", "Some other name"), 200));
                }}
        );
        return new ResponseEntity<Flight>(flight, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getFlights() throws ParseException {
        Flight firstFlight = new Flight(
                new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2017-04-21 14:34"),
                new ArrayList<Ticket>() {{
                    add(new Ticket(new Passenger("Some name", "Some other name"), 200));
                }}
        );
        Flight secondFlight = new Flight(
                new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2017-04-21 14:34"),
                new ArrayList<Ticket>() {{
                    add(new Ticket(new Passenger("Some other name", null), 400));
                }}
        );
        List<Flight> flights = new ArrayList<Flight>() {{
            add(firstFlight);
            add(secondFlight);
        }};
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

}
