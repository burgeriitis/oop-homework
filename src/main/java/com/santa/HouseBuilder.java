package com.santa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HouseBuilder {

    private static final int ADDITION_TO_PRICE_PER_FLOOR = 10;
    private static final int FIRST = 1;
    public static final int NO_BASEMENT = 0;

    private String houseAddress;
    private double basementArea;
    private List<Floor> floorList = new ArrayList<>();

    private HouseBuilder(String houseAddress, double basementArea) {
        this.houseAddress = houseAddress;
        this.basementArea = basementArea;
    }

    public static HouseBuilder houseWithBasement(String houseAddress, double basementArea) {
        return new HouseBuilder(houseAddress, basementArea);
    }

    public static HouseBuilder houseWithoutBasement(String houseAddress) {
        return new HouseBuilder(houseAddress, NO_BASEMENT);
    }

    public House build() {
        final Basement basement = basementArea == NO_BASEMENT ? null : new Basement(basementArea);
        House house = new House(houseAddress, basement);
        house.setFloors(floorList);
        return house;
    }

    public HouseBuilder addFloors(List<BasicFlatInfo> flats, BigDecimal basePrice, int floorCount) {
        int floorCounter = FIRST;
        int flatCounter = FIRST;
        while (floorCounter <= floorCount) {
            Floor floor = new Floor(floorCounter);
            for (BasicFlatInfo basicInfo : flats) {
                Flat flat = new Flat(flatCounter, basicInfo.getRoomCount(), basicInfo.getArea(), basePriceWithAddition(floorCounter, basePrice));
                floor.addFlat(flat);
                flatCounter++;
            }
            floorList.add(floor);
            floorCounter++;
        }
        return this;
    }

    private BigDecimal basePriceWithAddition(int floorNumber, BigDecimal basePrice) {
        BigDecimal additionToBasePricePerSquareMeter = new BigDecimal((floorNumber - 1) * ADDITION_TO_PRICE_PER_FLOOR);
        return basePrice.add(additionToBasePricePerSquareMeter);
    }
}
