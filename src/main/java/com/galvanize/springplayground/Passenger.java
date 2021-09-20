package com.galvanize.springplayground;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
