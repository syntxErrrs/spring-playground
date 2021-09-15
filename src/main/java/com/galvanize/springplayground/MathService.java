package com.galvanize.springplayground;

public class MathService {
    public String getVolumeString(String height, String width, String length) {
        Integer ht = Integer.valueOf(height);
        Integer wh = Integer.valueOf(width);
        Integer lh = Integer.valueOf(length);
        Integer volume = ht * wh * lh;
        return "The volume of a " + ht + "x" + wh + "x" + lh + " rectangle is " + volume;
    }
}
