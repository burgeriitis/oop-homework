package com.santa;

import java.util.ArrayList;
import java.util.List;

class Floor {

    private final List<Flat> flats = new ArrayList<>();
    private final int floorNr;
    private final int area;

    public Floor(int floorNr, int area) {
        this.floorNr = floorNr;
        this.area = area;
    }

    public List<Flat> getFlats() {
        return new ArrayList<>(flats);
    }

    public void addFlat(Flat flat) {
        flats.add(flat);
    }

    public int getFloorNr() {
        return floorNr;
    }

    public int getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "flats=" + flats +
                ", floorNr=" + floorNr +
                '}';
    }
}
