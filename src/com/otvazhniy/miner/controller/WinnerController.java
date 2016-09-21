package com.otvazhniy.miner.controller;

import com.otvazhniy.miner.model.Exceptions.WinnerException;
import com.otvazhniy.miner.model.Field;
import com.otvazhniy.miner.model.Square;

/**
 * Created by OTBA}|{HbIu` on 19.09.16.
 */
public class WinnerController {

    public static void win(Field field) throws WinnerException {
        int squaresSize=0;
        for(Square square:field){
            if(square!=Square.BOMB)
                squaresSize++;
        }
        if(squaresSize==0)
            throw new WinnerException();
    }
}
