package com.santa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        List<BasicFlatInfo> basicFlatInfoList = new ArrayList<>();
        basicFlatInfoList.add(new BasicFlatInfo(RoomCount.TWO, 45.6));
        basicFlatInfoList.add(new BasicFlatInfo(RoomCount.THREE, 78.9));
        basicFlatInfoList.add(new BasicFlatInfo(RoomCount.THREE, 70.8));

        House house = HouseBuilder.houseWithBasement("Hipokrata 112", 1600)
                .addFloors(basicFlatInfoList, BigDecimal.valueOf(1660.0), 10)
                .build();

        System.out.println(house);
    }
}
