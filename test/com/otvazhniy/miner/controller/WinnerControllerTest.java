package com.otvazhniy.miner.controller;

import com.otvazhniy.miner.model.Field;
import com.otvazhniy.miner.model.Square;

import java.awt.*;

/**
 * Created by OTBA}|{HbIu` on 20.09.16.
 */
public class WinnerControllerTest {
    private Field field=new Field(new Point(16,16));

    @org.junit.Before
    public void setUp() throws Exception {
        SquaresGenerator.generateBombs(field, Square.BOMB, field.getFieldSize().x*field.getFieldSize().y/4);
    }

    @org.junit.Test
    public void win() throws Exception {
        WinnerController.win(field);
    }

}