package com.scarlett.game.core.entity;

public class Coordinates {
    private float x;
    private float y;
    private float speedX;
    private float speedY;
    private float angle;


    public Coordinates(float x, float y, float speedX, float speedY, float angle) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.angle = angle;
    }

    public void update(){
        x += speedX;
        y += speedY;
        speedX = 0;
        speedY = 0;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle){
        this.angle = angle;
    }
}
