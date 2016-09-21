package com.otvazhniy.miner.controller;

import com.otvazhniy.miner.model.Field;
import com.otvazhniy.miner.model.Square;

import java.awt.*;
import java.util.Random;

import static java.lang.Math.abs;

/**
 * Created by OTBA}|{HbIu` on 19.09.16.
 */
public class SquaresGenerator {
    //720 -668

    public static void generateBombs(final Field field, final Square bomb, final int bombCount) {

        Random r=new Random();
        int maxX=field.getFieldSize().x;
        int maxY=field.getFieldSize().y;

        generateEmptyField(field,maxX,maxY);

        for(int i=0;i<bombCount;i++){
            Point newPoint=new Point(abs(r.nextInt()%maxX),abs(r.nextInt()%maxY));
            Square square=field.setSquare(newPoint,bomb);

            if(square==Square.BOMB) {
                i--;
            }else {
                generateNumbers(field,newPoint);
            }
        }

    }

    private static void generateEmptyField(Field field, int maxX, int maxY) {
        for(int x=0;x<maxX;x++){
            for(int y=0;y<maxY;y++){
                field.setSquare(new Point(x,y),Square.EMPTY);
            }
        }
    }

    private static void generateNumbers(final Field field, final Point point) {

        Point newPoint;
        for(int x=-1;x<2;x++){
            for (int y=-1;y<2;y++){
                //обходим бомбу вокруг и расставляем цифры
                newPoint=new Point(point.x+x,point.y+y);
                generateSquare(field,newPoint);
            }
        }

    }

    private static boolean generateSquare(Field field, Point newPoint) {
        Square tmp=field.getSquare(newPoint);
        if(tmp==null || tmp==Square.BOMB)//скорее всего мы вышли за пределы поля или попали на бомбу
            // , поэтому пропускаем этот поинт
            return false;
        if(tmp==Square.EMPTY || tmp==Square.FLAG || tmp==Square.UNKNOWN){//set ONE
            field.setSquare(newPoint,Square.ONE);
            return false;
        }
        Integer numberSquare=Integer.valueOf(tmp.getValue());//get from enum string value
        numberSquare++;//increase it
        Square newSquare=Square.fromInt(numberSquare);//create next enum
        field.setSquare(newPoint, newSquare);
        return true;
    }
}
