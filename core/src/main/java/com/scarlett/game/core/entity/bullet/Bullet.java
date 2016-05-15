package com.scarlett.game.core.entity.bullet;

import com.badlogic.gdx.math.Vector2;
import com.scarlett.game.core.entity.Entity;

public class Bullet extends Entity {
    private BulletDescriptor descriptor;

    public Bullet(BulletDescriptor descriptor, Vector2 position, float angle) {
        super(descriptor.getEntity(), position);
        this.descriptor = descriptor;
        stopping = false;
        speedX = getSpeedXBasedOnAngle(angle) * attributes.getSpeed();
        speedY = getSpeedYBasedOnAngle(angle) * attributes.getSpeed();
    }

    private float getSpeedXBasedOnAngle (float angle) {
        return (float) Math.cos(((angle - 90) * Math.PI) / 180);
    }

    private float getSpeedYBasedOnAngle (float angle) {
        return (float) Math.sin(((angle - 90) * Math.PI) / 180);
    }
}
