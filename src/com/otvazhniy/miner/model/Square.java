package com.otvazhniy.miner.model;

/**
 * Created by OTBA}|{HbIu` on 19.09.16.
 */
public enum Square{
    EMPTY("EMPTY"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"),
    SEVEN("7"), EIGHT("8"), BOMB("BOMB"), FLAG("FLAG"), UNKNOWN("UNKNOWN");

    private final String square;

    Square(String s) {

        this.square = s;
    }

    public String getValue() {
        return square;
    }

    public static Square fromInt(Integer i) {
        for (Square b : Square.values()) {
            if (i.toString().equals(b.getValue())) { return b; }
        }
        return null;
    }

}
