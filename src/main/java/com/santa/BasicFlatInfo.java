package com.santa;

import com.santa.components.RoomCount;

public class BasicFlatInfo {

    private final RoomCount roomCount;
    private final double area;

    public BasicFlatInfo(RoomCount roomCount, double area) {
        this.roomCount = roomCount;
        this.area = area;
    }

    public RoomCount getRoomCount() {
        return roomCount;
    }

    public double getArea() {
        return area;
    }
}
