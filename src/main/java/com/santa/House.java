package com.santa;

import java.util.ArrayList;
import java.util.List;

public class House {

    private final String address;
    private final Basement basement;
    private final List<Floor> floors = new ArrayList<>();

    public House(String address, Basement basement) {
        this.address = address;
        this.basement = basement;
    }

    public String getAddress() {
        return address;
    }

    public Basement getBasement() {
        return basement;
    }

    public List<Floor> getFloors() {
        return new ArrayList<>(floors);
    }

    public void setFloors(List<Floor> floors) {
        this.floors.addAll(floors);
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
                "address='" + address + '\'' +
                ", basement=" + basement +
                ", floors=" + floors +
                '}';
    }
}
