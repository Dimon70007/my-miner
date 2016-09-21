package com.otvazhniy.miner.controller;

import com.otvazhniy.miner.model.Exceptions.LooseException;
import com.otvazhniy.miner.model.Square;

/**
 * Created by OTBA}|{HbIu` on 19.09.16.
 */
public class LooseController {

    public static void loose(Square square) throws LooseException {
        if(square==Square.BOMB)
            throw new LooseException();
    }
}
