package com.scarlett.game.core;

public class GameService {
    private static ScarlettStationGame instance = null;

    static void setInstance(ScarlettStationGame game){
        instance = game;
    }

    public static ScarlettStationGame getInstance(){
        return instance;
    }
}
