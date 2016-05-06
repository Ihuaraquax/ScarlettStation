package com.scarlett.game.core.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.scarlett.game.core.ScarlettStationGame;

public class MouseInput {
    private static Vector3 mousePosition = null;

    public static Vector3 getInstance(){
        if(mousePosition == null){
            mousePosition = new Vector3(0,0,0);
        }
        mousePosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        return mousePosition;
    }

    public static Vector3 getUpdatedMousePosition(){
        Vector3 position = getInstance();
        ScarlettStationGame.getCamera().unproject(mousePosition);
        return position;
    }
}
