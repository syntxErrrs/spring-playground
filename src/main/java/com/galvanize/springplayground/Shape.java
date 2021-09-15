package com.galvanize.springplayground;

public class Shape {
    private String type;
    private String radius;
    private String height;
    private String width;

    public String getType() {
        return this.type;
    }

    public String getRadius() {
        return this.radius;
    }

    public String getHeight() {
        return this.height;
    }

    public String getWidth() {
        return this.width;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public Integer getRectangleAreaInteger() {
        return Integer.valueOf(this.width) * Integer.valueOf(this.height);
    }

    public double getCircleAreaDouble() {
        double radiusInteger = (Integer.valueOf(this.radius));
        return Math.PI * (radiusInteger * radiusInteger);
    }

}
