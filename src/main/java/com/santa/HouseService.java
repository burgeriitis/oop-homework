package com.santa;

import com.santa.components.Flat;
import com.santa.components.House;

import java.util.Iterator;

public class HouseService {

    private HouseRepository houseRepository;

    HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public void saveHouse(House house) {
        houseRepository.saveHouse(house);
    }

    public void nextBuyingPhase(String houseAddress, int flatNumber) {
        houseRepository.getHouseByAddress(houseAddress).getFloors().forEach(floor -> {
            Iterator iterator = floor.getIterator();
            while (iterator.hasNext()) {
                Flat flat = (Flat) iterator.next();
                if(flat.getFlatNumber() == flatNumber) {
                    flat.nextBuyingPhase();
                    houseRepository.updateFlatBuyingPhase(houseAddress, flat);
                    break;
                }
            }
        });
    }

    public void setToFirstBuyingPhase(String houseAddress, int flatNumber) {
        houseRepository.getHouseByAddress(houseAddress).getFloors().forEach(floor -> {
            Iterator iterator = floor.getIterator();
            while (iterator.hasNext()) {
                Flat flat = (Flat) iterator.next();
                if(flat.getFlatNumber() == flatNumber) {
                    flat.firstBuyingPhase();
                    houseRepository.updateFlatBuyingPhase(houseAddress, flat);
                    break;
                }
            }
        });
    }
}
