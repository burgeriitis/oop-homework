package com.santa.builder;

import com.santa.BasicFlatInfo;
import com.santa.WrongHouseBuildingParameters;
import com.santa.components.Basement;
import com.santa.components.Flat;
import com.santa.components.Floor;
import com.santa.components.House;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Builder creates houses with assigned floor count, but no more than 50 floors high, as it requires other way to build
 * house.
 */
public class HouseBuilder {

    private static final int ADDITION_TO_PRICE_PER_FLOOR = 10;
    private static final int FIRST = 1;
    private static final int MAX_FLOOR_COUNT = 50;

    private final String houseAddress;
    private final double basementArea;
    private final List<Floor> floorList = new ArrayList<>();

    private HouseBuilder(String houseAddress, double basementArea) {
        this.houseAddress = houseAddress;
        this.basementArea = basementArea;
    }

    public static HouseBuilder createBuilderWithInfo(String houseAddress, double basementArea) {
        return new HouseBuilder(houseAddress, basementArea);
    }

    public HouseBuilder addFloors(List<BasicFlatInfo> flats, BigDecimal basePrice, int floorCount) throws WrongHouseBuildingParameters {
        if(floorCount < 1) {
            throw new WrongHouseBuildingParameters("Thre should be at least one floor");
        } else if (flats == null || flats.size() == 0) {
            throw new WrongHouseBuildingParameters("You should define flats to build");
        }
        int floorCounter = FIRST;
        int flatCounter = FIRST;
        while (floorCounter <= floorCount && flatCounter <= MAX_FLOOR_COUNT) {
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

    public House build() {
        House house = new House(houseAddress, new Basement(basementArea));
        house.addMultipleFloors(floorList);
        return house;
    }

    private BigDecimal basePriceWithAddition(int floorNumber, BigDecimal basePrice) {
        BigDecimal additionToBasePricePerSquareMeter = new BigDecimal((floorNumber - 1) * ADDITION_TO_PRICE_PER_FLOOR);
        return basePrice.add(additionToBasePricePerSquareMeter);
    }
}
