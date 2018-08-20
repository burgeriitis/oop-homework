package com.santa;

public class BasicFlatInfo {

    private final int roomCount;
    private final int area;

    public BasicFlatInfo(int roomCount, int area) {
        this.roomCount = roomCount;
        this.area = area;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public int getArea() {
        return area;
    }
}
