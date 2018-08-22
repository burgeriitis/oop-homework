package com.santa;

import java.util.ArrayList;
import java.util.List;

class Floor {

    private final List<Flat> flats = new ArrayList<>();
    private final int floorNr;

    public Floor(int floorNr) {
        this.floorNr = floorNr;
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

    @Override
    public String toString() {
        return "Floor{" +
                "flats=" + flats +
                ", floorNr=" + floorNr +
                '}';
    }
}
