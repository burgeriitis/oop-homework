package com.santa;

import java.math.BigDecimal;
import java.math.MathContext;

public class Flat {

    private final Integer flatNumber;
    private final RoomCount roomCount;
    private final double area;
    private BigDecimal pricePerSquareMeter;
    private boolean available;

    Flat(Integer flatNumber, RoomCount roomCount, double area, BigDecimal pricePerSquareMeter) {
        this.flatNumber = flatNumber;
        this.roomCount = roomCount;
        this.area = area;
        this.pricePerSquareMeter = pricePerSquareMeter;
        this.available = true;
    }

    public BigDecimal price() {
        return pricePerSquareMeter.multiply(new BigDecimal(this.area), new MathContext(2));
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public RoomCount getRoomCount() {
        return roomCount;
    }

    public double getArea() {
        return area;
    }

    public BigDecimal getPricePerSquareMeter() {
        return pricePerSquareMeter;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setPricePerSquareMeter(BigDecimal pricePerSquareMeter) {
        this.pricePerSquareMeter = pricePerSquareMeter;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "flatNumber=" + flatNumber +
                ", roomCount=" + roomCount +
                ", area=" + area +
                ", pricePerSquareMeter=" + pricePerSquareMeter +
                ", available=" + available +
                '}';
    }
}
