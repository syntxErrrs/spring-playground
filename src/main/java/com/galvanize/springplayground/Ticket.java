package com.galvanize.springplayground;

public class Ticket {
    public Passenger passenger;
    public int price;

    public Ticket() {
    }

    public Ticket(Passenger passenger, int price) {
        this.passenger = passenger;
        this.price = price;
    }
}
