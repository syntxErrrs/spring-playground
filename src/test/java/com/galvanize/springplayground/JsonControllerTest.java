package com.galvanize.springplayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
class JsonControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void jsonPersonReturnsAPerson() throws Exception {
        this.mvc.perform(
                        get("/json/person")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Jon")))
                .andExpect(jsonPath("$.lastName", is("Phillips")));
    }

    @Test
    void jsonPeopleReturnsArrayOfPersons() throws Exception {
        this.mvc.perform(
                get("/json/people")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName", is("Jon")))
                .andExpect(jsonPath("$[0].lastName", is("Phillips")));
    }

}