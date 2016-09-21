package com.otvazhniy.miner.controller;

import com.otvazhniy.miner.model.Exceptions.AlreadyOpenedException;
import com.otvazhniy.miner.model.Exceptions.LooseException;
import com.otvazhniy.miner.model.Exceptions.OccupiedByFlagException;
import com.otvazhniy.miner.model.Exceptions.WinnerException;
import com.otvazhniy.miner.model.Field;
import com.otvazhniy.miner.model.Square;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by OTBA}|{HbIu` on 19.09.16.
 */
public class ClickController extends GridLayout{

    public static HashMap<Point,Square> leftClickController(Field field, Point point) throws LooseException, WinnerException, OccupiedByFlagException {
        checkFlag(field,point);
        Square square=field.getSquare(point);
        LooseController.loose(square);
        HashMap<Point,Square> result=new HashMap<>();
        result.put(point,square);
        if(square!=Square.EMPTY){
            WinnerController.win(field);
            return result;
        }
        result=openAroundSpecifiedSquare(result,field,point,Square.EMPTY);
        WinnerController.win(field);
        return result;
    }

    public static Square rightClickController(Field field, Point point) throws AlreadyOpenedException {
        Square s=field.getSquare(point);
        if(s==null) {
            throw new AlreadyOpenedException();
        }
        field.setSquare(point, s);
        Square flag=field.getFlag(point);
        if(flag==Square.UNKNOWN)
            return field.removeFlag(point);
        if(flag==Square.FLAG)
            return field.setFlag(point,Square.UNKNOWN);
        return field.setFlag(point,Square.FLAG);


    }

    private static void checkFlag(Field field, Point point) throws OccupiedByFlagException {
        if(field.getFlag(point)==Square.FLAG)
            throw new OccupiedByFlagException();
    }

    private static HashMap<Point,Square> openAroundSpecifiedSquare(HashMap<Point, Square> result, Field field, Point point, Square square) {

        for(int i=1;true;i++){
            if(square!=Square.EMPTY)
                break;
            int size=result.size();
            result= goOnSpecifiedSquare(result,field,point,square,i);//find all empty square
            if(size==result.size())
                break;
        }
        Set<Point> pointSet=new HashSet<>(result.keySet());
        for(Point p:pointSet){
            result= goOnSpecifiedSquare(result,field,p,square,1);//find all square in (1,8]
        }
        if(square==Square.EIGHT)
            return result;
        if(square==Square.EMPTY)
            return openAroundSpecifiedSquare(result, field, point, Square.ONE);
        Integer numberSquare=Integer.valueOf(square.getValue());//get from enum string value
        numberSquare++;//increase it
        Square newSquare=Square.fromInt(numberSquare);//create next enum
        return openAroundSpecifiedSquare(result, field, point, newSquare);
    }



    private static HashMap<Point, Square> goOnSpecifiedSquare(HashMap<Point, Square> result, Field field, Point point, Square square, int i) {
        Point p;
        Square s;
        for(int x=-i;x<=i;x++){
            for(int y=-i;y<=i;y++){
                p=new Point(point.x +x,point.y +y);
                if(result.get(p)!=null)
                    continue;
                s=field.getSquare(p);// getSquare(p) REMOVES square out of field and put in s
                if(s==null || s!=square){
                    field.setSquare(p, s);// if removed s is not square then put it in field
                    continue;
                }
                result.put(p,s);
            }
        }
        return result;
    }
}
