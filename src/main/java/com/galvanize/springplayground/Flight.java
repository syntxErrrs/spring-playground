package com.galvanize.springplayground;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flight {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "America/Chicago")
    public Date departs;
    public List<Ticket> tickets;

    public Flight() {
    }

    public Flight(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Flight(Date departs, List<Ticket> tickets) {
        this.departs = departs;
        this.tickets = tickets;
    }

    public Map<String, Integer> getTotalCost() {
        Map<String, Integer> result = new HashMap<>();
        result.put("result", this.tickets.stream().map(x -> x.price).reduce(0, Integer::sum));
        return result;
    }


}
