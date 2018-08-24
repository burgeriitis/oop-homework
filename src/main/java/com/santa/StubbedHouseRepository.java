package com.santa;

import com.santa.components.Flat;
import com.santa.components.House;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * In real lif class like this would be implemented for usage with some kind of data layer.
 * For now it's just to show how data object cold be used and created.
 */
public class StubbedHouseRepository implements HouseRepository {

    private House house;

    @Override
    public List<House> getAllHouses() {
        return Collections.singletonList(house);
    }

    @Override
    public House getHouseByAddress(String address) {
        return house;
    }

    @Override
    public void saveHouse(House house) {
        this.house = house;
    }

    @Override
    public void deleteHouse(String address) {
        this.house = null;
    }

    @Override
    public void updateFlatBuyingPhase(String houseAddress, Flat flat) {
        getHouseByAddress(houseAddress).getFloors().forEach(floor -> {
            Iterator iterator = floor.getIterator();
            while (iterator.hasNext()) {
                Flat oldFlat = (Flat) iterator.next();
                if (oldFlat.getFlatNumber().equals(flat.getFlatNumber())) {
                    oldFlat.setFlatBuyingPhase(flat.getFlatState());
                }
            }
        });
    }
}
