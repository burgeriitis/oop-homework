package com.santa.components;

public class Basement {
    private final double area;

    public Basement(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Basement{" +
                "area=" + area +
                '}';
    }
}
