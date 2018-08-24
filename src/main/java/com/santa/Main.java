package com.santa;

import com.santa.builder.HouseBuilder;
import com.santa.components.House;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.santa.components.RoomCount.THREE;
import static com.santa.components.RoomCount.TWO;

public class Main {

    private static final String HOUSE_ADDRESS = "Hipokrata 112";

    public static void main(String args[]) {
        List<BasicFlatInfo> basicFlatInfoList = new ArrayList<>();
        basicFlatInfoList.add(new BasicFlatInfo(TWO, 45.6));
        basicFlatInfoList.add(new BasicFlatInfo(THREE, 78.9));
        basicFlatInfoList.add(new BasicFlatInfo(THREE, 70.8));

        House house = null;
        try {
            house = HouseBuilder.createBuilderWithInfo(HOUSE_ADDRESS, 1600)
                    .addFloors(basicFlatInfoList, BigDecimal.valueOf(1660.0), 3)
                    .build();
        } catch (WrongHouseBuildingParameters wrongHouseBuildingParameters) {
            System.out.println("Please use valid parameters for house building!");
        }
        System.out.println(house);

        HouseService service = new HouseService(new StubbedHouseRepository());
        service.saveHouse(house);
        service.nextBuyingPhase(HOUSE_ADDRESS, 1);
        System.out.println(house);
        service.nextBuyingPhase(HOUSE_ADDRESS, 1);
        System.out.println(house);
        service.nextBuyingPhase(HOUSE_ADDRESS, 2);
        System.out.println(house);
        service.setToFirstBuyingPhase(HOUSE_ADDRESS, 2);
        System.out.println(house);
    }
}
