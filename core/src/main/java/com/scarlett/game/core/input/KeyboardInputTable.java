package com.scarlett.game.core.input;

import com.badlogic.gdx.Input;

class KeyboardInputTable {
    int getUpKey(){
        return Input.Keys.W;
    }
    int getDownKey(){
        return Input.Keys.S;
    }
    int getLeftKey(){
        return Input.Keys.A;
    }
    int getRightKey(){
        return Input.Keys.D;
    }
}
