package com.galvanize.springplayground;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class FlightControllerTest {

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        System.out.println("url = " + url);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }

    @Autowired
    MockMvc mvc;
    String depart = "2017-04-21 14:34";
    String firstName = "Some name";
    String lastName = "Some other name";
    int price = 200;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getFlightReturnsFlightInJsonFormat() throws Exception {
        this.mvc.perform(
                        get("/flights/flight")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departs", is(depart)))
                .andExpect(jsonPath("$.tickets[0].passenger.firstName", is(firstName)))
                .andExpect(jsonPath("$.tickets[0].passenger.lastName", is(lastName)))
                .andExpect(jsonPath("$.tickets[0].price", is(price)));
    }

    @Test
    void getFlightsReturnsListOfFlightsInJsonFormat() throws Exception {
        this.mvc.perform(
                        get("/flights")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].departs", is(depart)))
                .andExpect(jsonPath("$.[0].tickets[0].passenger.firstName", is(firstName)))
                .andExpect(jsonPath("$.[0].tickets[0].passenger.lastName", is(lastName)))
                .andExpect(jsonPath("$.[0].tickets[0].price", is(price)))
                .andExpect(jsonPath("$.[1].departs", is(depart)))
                .andExpect(jsonPath("$.[1].tickets[0].passenger.firstName", is(lastName)))
                .andExpect(jsonPath("$.[1].tickets[0].price", is(price + 200)));
    }

    @Test
    void postFlightCalculatesTotalPrice() throws Exception {
        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket1 = new Ticket(new Passenger("Name1", "Last1"), 200);
        Ticket ticket2 = new Ticket(new Passenger("Name1", "Last1"), 150);
        tickets.add(ticket1);
        tickets.add(ticket2);
        Flight flight = new Flight(tickets);

        String json = objectMapper.writeValueAsString(flight);

        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mvc.perform(request).andExpect(status().isOk()
        ).andExpect(jsonPath("$.result", is(350)));

        json = """
                {
                    "tickets": [
                      {
                        "passenger": {
                          "firstName": "Some name",
                          "lastName": "Some other name"
                        },
                        "price": 200
                      },
                      {
                        "passenger": {
                          "firstName": "Name B",
                          "lastName": "Name C"
                        },
                        "price": 150
                      }
                    ]
                  }
                """;

        request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mvc.perform(request).andExpect(status().isOk()
        ).andExpect(jsonPath("$.result", is(350)));


        json = getJSON("/data.json");

        request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mvc.perform(request).andExpect(status().isOk()
        ).andExpect(jsonPath("$.result", is(350)));

    }

}