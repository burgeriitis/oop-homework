package com.santa.components;

public enum RoomCount {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4);

    private int count;

    RoomCount(int count) {
        this.count = count;
    }

    public int count() {
        return count;
    }
}
