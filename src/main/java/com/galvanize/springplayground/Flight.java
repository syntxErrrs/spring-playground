package com.galvanize.springplayground;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Flight {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonProperty("Departs")
    public Date departs;
    @JsonProperty("Tickets")
    public List<Ticket> tickets;

    public Flight(Date departs, List<Ticket> tickets) {
        this.departs = departs;
        this.tickets = tickets;
    }

}


