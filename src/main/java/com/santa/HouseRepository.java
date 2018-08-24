package com.santa;

import com.santa.components.Flat;
import com.santa.components.House;

import java.util.List;

public interface HouseRepository {

    List<House> getAllHouses();

    House getHouseByAddress(String address);

    void saveHouse(House house);

    void deleteHouse(String address);

    void updateFlatBuyingPhase(String houseAddress, Flat flat);
}
