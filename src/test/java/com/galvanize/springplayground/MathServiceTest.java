package com.galvanize.springplayground;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathServiceTest {
    private final MathService mathService = new MathService();

    @Test
    void getVolumeString() {
        String height = "3";
        String width = "4";
        String length = "5";
        assertEquals("The volume of a 3x4x5 rectangle is 60", mathService.getVolumeString(height, width, length));
    }
}
