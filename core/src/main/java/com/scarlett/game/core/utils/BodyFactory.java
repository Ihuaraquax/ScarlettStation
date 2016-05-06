package com.scarlett.game.core.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.scarlett.game.core.ScarlettStationGame;
import com.scarlett.game.core.entity.Entity;

public class BodyFactory {

    private final static float WALL_SIZE = (float)0.5;

    public static Body createRectangularBody(float x, float y, float height, float width, Entity userData){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);

        World world = ScarlettStationGame.getWorld();
        Body body = world.createBody(bodyDef);

        PolygonShape rectangle = new PolygonShape();
        rectangle.setAsBox(height, width);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = rectangle;
        fixtureDef.density = 0.6f;
        fixtureDef.friction = 0.8f;
        fixtureDef.restitution = 0.8f;

        body.createFixture(fixtureDef);
        body.setUserData(userData);
        rectangle.dispose();
        return body;
    }

    public static Body createCircularBody(float x, float y, float size, Entity userData){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);

        World world = ScarlettStationGame.getWorld();
        Body body = world.createBody(bodyDef);

        CircleShape circle = new CircleShape();
        circle.setRadius(size);
        Double random = Math.random();

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = 0.6f;
        fixtureDef.friction = random.floatValue();
        fixtureDef.restitution = 0.8f;

        body.createFixture(fixtureDef);
        MassData mass = new MassData();
        mass.mass = 100 * (random.floatValue() * 1000f);
        body.setMassData(mass);
        body.setUserData(userData);
        circle.dispose();
        return body;
    }

    public static Body createSquareWall(float x, float y, Entity userData){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x, y);

        World world = ScarlettStationGame.getWorld();
        Body body = world.createBody(bodyDef);

        PolygonShape rectangle = new PolygonShape();
        rectangle.setAsBox(WALL_SIZE, WALL_SIZE);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = rectangle;
        fixtureDef.density = 0.6f;
        fixtureDef.friction = 0.8f;
        fixtureDef.restitution = 0.8f;

        body.createFixture(fixtureDef);
        body.setUserData(userData);
        rectangle.dispose();
        return body;
    }

    public static void createBounds(Entity boundEntity){
        Filter filter = new Filter();
        filter.categoryBits = (short)8;
        filter.maskBits = (short)15;
        World world = ScarlettStationGame.getWorld();
        BodyDef bottomWallDef = new BodyDef();
        bottomWallDef.position.set(new Vector2(0,0));
        Body bottomWallBody = world.createBody(bottomWallDef);

        PolygonShape bottomBox = new PolygonShape();
        bottomBox.setAsBox(40f,1f);
        bottomWallBody.createFixture(bottomBox, 0.0f);
        bottomBox.dispose();
        bottomWallBody.getFixtureList().get(0).setFilterData(filter);
        bottomWallBody.setUserData(boundEntity);

        BodyDef rightWallDef = new BodyDef();
        rightWallDef.position.set(new Vector2(41f,0));
        Body rightWallBody = world.createBody(rightWallDef);

        PolygonShape rightBox = new PolygonShape();
        rightBox.setAsBox(1f,40f);
        rightWallBody.createFixture(rightBox, 0.0f);
        rightWallBody.getFixtureList().get(0).setFilterData(filter);
        rightWallBody.setUserData(boundEntity);
        rightBox.dispose();


        BodyDef leftWallDef = new BodyDef();
        leftWallDef.position.set(new Vector2(-1f,40f));
        Body leftWallBody = world.createBody(leftWallDef);

        PolygonShape leftBox = new PolygonShape();
        leftBox.setAsBox(1f,40f);
        leftWallBody.createFixture(leftBox, 0.0f);
        leftWallBody.getFixtureList().get(0).setFilterData(filter);
        leftWallBody.setUserData(boundEntity);
        leftBox.dispose();


        BodyDef upWallDef = new BodyDef();
        upWallDef.position.set(new Vector2(0,40f));
        Body upWallBody = world.createBody(upWallDef);

        PolygonShape upBox = new PolygonShape();
        upBox.setAsBox(40f,1f);
        upWallBody.createFixture(upBox, 0.0f);
        upWallBody.getFixtureList().get(0).setFilterData(filter);
        upWallBody.setUserData(boundEntity);
        upBox.dispose();
    }
}
