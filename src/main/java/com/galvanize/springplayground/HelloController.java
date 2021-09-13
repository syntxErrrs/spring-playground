package com.galvanize.springplayground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String getHello() {
        return "Hello from Spring!";
    }

    @GetMapping("/math/pi")
    public String getPi() {
        return "3.141592653589793";
    }

}
