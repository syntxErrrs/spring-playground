package com.galvanize.springplayground;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Passenger {
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("LastName")
    public String lastName;

    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
