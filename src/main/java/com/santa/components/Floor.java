package com.santa.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Floor implements Aggregate {

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
    public Iterator getIterator() {
        return flats.iterator();
    }

    @Override
    public String toString() {
        return "Floor{" +
                "flats=" + flats +
                ", floorNr=" + floorNr +
                '}';
    }
}
