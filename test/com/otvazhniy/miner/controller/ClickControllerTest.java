package com.otvazhniy.miner.controller;

import com.otvazhniy.miner.model.Exceptions.AlreadyOpenedException;
import com.otvazhniy.miner.model.Exceptions.OccupiedByFlagException;
import com.otvazhniy.miner.model.Exceptions.WinnerException;
import com.otvazhniy.miner.model.Field;
import com.otvazhniy.miner.model.Square;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Map;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 * Created by OTBA}|{HbIu` on 21.09.16.
 */
public class ClickControllerTest {

    private Field field=new Field(new Point(5,5));

    @Test
    public void leftClickControllerWinnerTest() throws Exception {
        SquaresGenerator.generateBombs(field, Square.BOMB, 0);//field.getFieldSize().x*field.getFieldSize().y/4);
        Point p=new Point(1,1);
        Map<Point,Square> map;
        try{
            map=ClickController.leftClickController(field,p);
            System.out.println(map.toString());
            fail();
        }catch (WinnerException e){

        }

    }

    @Test
    public void twoLeftClickControllerTest() throws Exception {
        SquaresGenerator.generateBombs(field, Square.BOMB, field.getFieldSize().x*field.getFieldSize().y/4);
        Point p=new Point(1,1);
        Map<Point,Square> map;
        map=ClickController.leftClickController(field,p);
        assertNotEquals(map.toString(),ClickController.leftClickController(field,p).toString());
            System.out.println(map.toString());

    }
    @Test
    public void rightClickControllerTest() throws Exception {
        SquaresGenerator.generateBombs(field, Square.BOMB,field.getFieldSize().x*field.getFieldSize().y/4);
        Point p=new Point(0,0);
        try {
            System.out.println(ClickController.rightClickController(field,p));
            System.out.println(ClickController.rightClickController(field,p));
        }catch (AlreadyOpenedException | OccupiedByFlagException | WinnerException e){
        }
     }

}