package com.galvanize.springplayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class FlightControllerTest {

    @Autowired
    MockMvc mvc;

    String depart = "2017-04-21 14:34";
    String firstName = "Some name";
    String lastName = "Some other name";
    int price = 200;

    @Test
    void getFlightReturnsFlightInJsonFormat() throws Exception {
        this.mvc.perform(
                        get("/flights/flight")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Departs", is(depart)))
                .andExpect(jsonPath("$.Tickets[0].Passenger.FirstName", is(firstName)))
                .andExpect(jsonPath("$.Tickets[0].Passenger.LastName", is(lastName)))
                .andExpect(jsonPath("$.Tickets[0].Price", is(price)));
    }

    @Test
    void getFlightsReturnsListOfFlightsInJsonFormat() throws Exception {
        this.mvc.perform(
                        get("/flights")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].Departs", is(depart)))
                .andExpect(jsonPath("$.[0].Tickets[0].Passenger.FirstName", is(firstName)))
                .andExpect(jsonPath("$.[0].Tickets[0].Passenger.LastName", is(lastName)))
                .andExpect(jsonPath("$.[0].Tickets[0].Price", is(price)))
                .andExpect(jsonPath("$.[1].Departs", is(depart)))
                .andExpect(jsonPath("$.[1].Tickets[0].Passenger.FirstName", is(lastName)))
                .andExpect(jsonPath("$.[1].Tickets[0].Price", is(price + 200)));
    }

}