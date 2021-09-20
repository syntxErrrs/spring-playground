package com.galvanize.springplayground;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ticket {
    @JsonProperty("Passenger")
    public Passenger passenger;
    @JsonProperty("Price")
    public int price;

    public Ticket(Passenger passenger, int price) {
        this.passenger = passenger;
        this.price = price;
    }
}
