package com.galvanize.springplayground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/json")
public class JsonController {

    @GetMapping("/person")
    public Person getPerson() {
        return new Person("Jon", "Phillips");
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        return new ArrayList<Person>() {
            {
                add(new Person("Jon", "Phillips"));
                add(new Person("Smokey", "TheBear"));
            }
        };
    }

    public static class Person {
        public String firstName;
        public String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

}
