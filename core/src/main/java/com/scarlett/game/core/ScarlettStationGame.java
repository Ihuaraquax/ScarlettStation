package com.scarlett.game.core;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.scarlett.game.core.entity.Entity;
import com.scarlett.game.core.entity.player.Player;
import com.scarlett.game.core.input.KeyboardInput;
import com.scarlett.game.core.input.MouseInput;

public class ScarlettStationGame implements ApplicationListener {
    public static final float PIXELS_TO_METERS = 1/100f;
    private static final float VIEWPORT_WIDTH = 80f;
    private static final float VIEWPORT_HEIGHT = 80f;
    private static final float TIME_STEP = 1/120f;
    private SpriteBatch batch;
    private static Entity player;
    private static Camera camera;
    private static World world;
    private Box2DDebugRenderer debugRenderer;
    private KeyboardInput keyboardInput;

    @Override
    public void create() {
        Box2D.init();
        batch = new SpriteBatch();
        createCamera();
        debugRenderer = new Box2DDebugRenderer();
        world = new World(Vector2.Zero, true);
        player = Player.createPlayer("player.xml");
        keyboardInput = new KeyboardInput();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {
        display();
        update();
    }

    private void display(){
        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        getCamera().update();
        batch.setProjectionMatrix(getCamera().combined);
        debugRenderer.render(world, getCamera().combined);
        batch.begin();
        player.display(batch);
        batch.end();
    }
    private void update(){
        keyboardInput.processInput((Player)player);
        MouseInput.processInput((Player)player);

        player.update();
        getWorld().step(TIME_STEP, 12, 2);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        batch.dispose();
        world.dispose();
    }

    private void createCamera(){
        camera = new OrthographicCamera(VIEWPORT_WIDTH,VIEWPORT_HEIGHT);
        getCamera().position.set(VIEWPORT_WIDTH/2, VIEWPORT_HEIGHT/2, 0);
        getCamera().update();
    }

    public static Camera getCamera() {
        return camera;
    }

    public static World getWorld(){
        return world;
    }

    public static Entity getPlayer(){
        return player;
    }
}
