package com.otvazhniy.miner.view;

/**
 * Created by OTBA}|{HbIu` on 21.09.16.
 */
public interface GUI {

    int getWidth();

    int getHeight();

    int getX();

    int getY();

    String getSprite();

    int receiveClick(int x, int y, int button);
}
