package com.santa.components;

import com.santa.state.FlatBuyingPhase;
import com.santa.state.FreeFlat;

import java.math.BigDecimal;
import java.math.MathContext;

public class Flat {

    private final Integer flatNumber;
    private final RoomCount roomCount;
    private final double area;
    private BigDecimal pricePerSquareMeter;
    private FlatBuyingPhase flatState;

    public Flat(Integer flatNumber, RoomCount roomCount, double area, BigDecimal pricePerSquareMeter) {
        this.flatNumber = flatNumber;
        this.roomCount = roomCount;
        this.area = area;
        this.pricePerSquareMeter = pricePerSquareMeter;
        this.flatState = new FreeFlat(this);
    }

    public BigDecimal getPrice() {
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

    public void setPricePerSquareMeter(BigDecimal pricePerSquareMeter) {
        this.pricePerSquareMeter = pricePerSquareMeter;
    }

    public String getStateDescription() {
        return flatState.phaseDescription();
    }

    public void setFlatBuyingPhase(FlatBuyingPhase flatState) {
        this.flatState = flatState;
    }

    public FlatBuyingPhase getFlatState() {
        return flatState;
    }

    public void nextBuyingPhase() {
        flatState.nextBuyingPhase();
    }

    public void firstBuyingPhase() {
        flatState.firstBuyingPhase();
    }

    @Override
    public String toString() {
        return "Flat{" +
                "flatNumber=" + flatNumber +
                ", roomCount=" + roomCount +
                ", area=" + area +
                ", pricePerSquareMeter=" + pricePerSquareMeter +
                ", flatState=" + flatState.phaseDescription() +
                '}';
    }
}
