package com.scarlett.game.core.input;

import com.badlogic.gdx.Gdx;
import com.scarlett.game.core.entity.player.Player;

public class KeyboardInput {
    private KeyboardInputTable table = new KeyboardInputTable();
    public void processInput(Player player){
        if(Gdx.input.isKeyPressed(table.getUpKey())){
            player.move(0,1);
        }
        if(Gdx.input.isKeyPressed(table.getDownKey())){
            player.move(0,-1);
        }
        if(Gdx.input.isKeyPressed(table.getLeftKey())){
            player.move(-1,0);
        }
        if(Gdx.input.isKeyPressed(table.getRightKey())){
            player.move(1,0);
        }
    }
}
