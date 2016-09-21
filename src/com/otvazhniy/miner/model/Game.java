package com.otvazhniy.miner.model;

/**
 * Created by OTBA}|{HbIu` on 19.09.16.
 */
public class Game {
//720 -668
    private Field field;
    private Player player;
    private Difficult difficult;
    private static String GAME_NAME= "MyMiner";

    public Game(final Player player, final Field field, Difficult difficult) {
        this.player = player;
        this.field=field;
        this.difficult = difficult;
    }

    public static String getGameName() {
        return GAME_NAME;
    }

    public Field getField() {
        return field;
    }

    public Player getPlayer() {
        return player;
    }

    public Difficult getDifficult() {
        return difficult;
    }

}
