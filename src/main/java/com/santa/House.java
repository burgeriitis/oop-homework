package com.santa;

import java.util.ArrayList;
import java.util.List;

public class House {

    private final String address;
    private List<Floor> floors = new ArrayList<>();

    public House(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public List<Floor> getFloors() {
        return new ArrayList<>(floors);
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    private List<Flat> getAllFlats() {
        List<Flat> flats = new ArrayList<>();
        floors.forEach(floor -> flats.addAll(floor.getFlats()));
        return flats;
    }

    @Override
    public String toString() {
        return "House{" +
                ", address='" + address + '\'' +
                ", floors=" + floors +
                '}';
    }
}
