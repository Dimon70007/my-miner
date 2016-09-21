package com.otvazhniy.miner.model;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by OTBA}|{HbIu` on 19.09.16.
 */
public class Player {

    private final String name;
    private final HashSet<Time> statistiks=new HashSet<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Time> getStatistiks() {
        return statistiks;
    }

    public void setTimeOfWiner(Time timeOfWinner) {
        this.statistiks.add(timeOfWinner);
    }

//    Timer timer = new Timer();
//timer.schedule(new SayHello(), 0, 5000);
}
