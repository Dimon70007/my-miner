package com.otvazhniy.miner.model;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by OTBA}|{HbIu` on 19.09.16.
 */
public class Field implements Iterable<Square> {

    private final Point fieldSize;
    private final HashMap<Point,Square> squares;
    private final HashMap<Point,Square> flags;

    public Field(final Point fieldSize) {
        this.fieldSize=fieldSize;
        this.squares = new HashMap<>(fieldSize.x*fieldSize.y);
        this.flags = new HashMap<>();
    }


    public Point getFieldSize() {
        return this.fieldSize;
    }

    public Square getSquare(Point point) {
        return squares.remove(point);
    }
    public Square setSquare(Point point, Square square) {
        return squares.put(point,square);
    }


    public Square getFlag(Point point) {
        return flags.get(point);
    }
    public Square setFlag(Point point, Square flag) {
        return flags.put(point,flag);
    }
    public Square removeFlag(Point point) {
        return flags.remove(point);
    }


    @Override
    public Iterator<Square> iterator() {
        return squares.values().iterator();
    }
}
