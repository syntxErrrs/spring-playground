package com.galvanize.springplayground;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService mathService = new MathService();

    @GetMapping("/pi")
    public String getPi() {
        return "3.141592653589793";
    }

    @RequestMapping("/volume/{height}/{width}/{length}")
    public String getVolume(
            @PathVariable String height,
            @PathVariable String width,
            @PathVariable String length
            ) {
       return mathService.getVolumeString(height, width, length);
    }

}
