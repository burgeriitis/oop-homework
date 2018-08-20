package com.santa;

import java.math.BigDecimal;
import java.util.List;

public class HouseBuilder {

    private static final int ADDITION_TO_PRICE_PER_FLOOR = 10;
    private static final int FIRST = 1;

    private House house;

    public HouseBuilder(String houseAddress) {
        this.house = new House(houseAddress);
    }

    public House build() {
        return house;
    }

    public HouseBuilder addFloors(List<BasicFlatInfo> flats, BigDecimal basePrice, int floorCount) {


        return this;
    }

    private BigDecimal calculateBasePrice(int floorNumber, BigDecimal basePrice) {
        BigDecimal additionToBasePricePerSquareMeter = new BigDecimal((floorNumber - 1) * ADDITION_TO_PRICE_PER_FLOOR);
        return basePrice.add(additionToBasePricePerSquareMeter);
    }
}
