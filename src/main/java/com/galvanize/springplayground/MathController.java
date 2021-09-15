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

    @PostMapping("/area")
    public String getArea(Shape shape) {
        String areaString = shape.getType().equals("circle") ?
                "circle with a radius of " + shape.getRadius() + " is " + shape.getCircleAreaDouble() :
                shape.getWidth() + "x" + shape.getHeight() + " rectangle is " + shape.getRectangleAreaInteger();

        return "Area of a " + areaString;
    }

}
