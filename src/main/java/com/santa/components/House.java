package com.santa.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class House implements Aggregate{

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

    public void addMultipleFloors(List<Floor> floors) {
        this.floors.addAll(floors);
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    @Override
    public Iterator getIterator() {
        return floors.iterator();
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
