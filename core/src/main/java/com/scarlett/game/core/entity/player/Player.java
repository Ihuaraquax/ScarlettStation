package com.scarlett.game.core.entity.player;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.scarlett.game.core.entity.Entity;
import com.scarlett.game.core.input.MouseInput;

public class Player extends Entity{
    public Player(PlayerDescriptor descriptor) {
        super(descriptor.getEntityDescriptor(), new Vector2(10, 10));
    }

    @Override
    public void specificUpdate(){
        float mouseX = MouseInput.getUpdatedMousePosition().x;
        float mouseY = MouseInput.getUpdatedMousePosition().y;
        float playerX = body.getPosition().x;
        float playerY = body.getPosition().y;
        float angle = getAngle(playerX ,playerY , mouseX, mouseY);
        body.setTransform(body.getPosition(),angle * MathUtils.degreesToRadians);
    }

    public static Entity createPlayer(String filepath){
        PlayerDescriptor descriptor = PlayerDescriptor.getFromFile(filepath);
        return new Player(descriptor);
    }

    private static float getAngle(float x1, float y1, float x2, float y2){
        float angle;
        float dX, dY;
        dX = x2 - x1;
        dY = y1 - y2;
        angle = (float) (180 + (Math.atan(dX/dY) * 180 / Math.PI));
        if(y2 <= y1)angle += 180;
        return angle;
    }
}
