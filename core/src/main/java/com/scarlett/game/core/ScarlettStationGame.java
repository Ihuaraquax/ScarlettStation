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
import com.scarlett.game.core.entity.allentities.AllEntities;
import com.scarlett.game.core.entity.player.Player;
import com.scarlett.game.core.event.AllEvents;
import com.scarlett.game.core.input.KeyboardInput;
import com.scarlett.game.core.input.MouseInput;
import com.scarlett.game.core.utils.BodyFactory;

public class ScarlettStationGame implements ApplicationListener {
    public static final float PIXELS_TO_METERS = 1/100f;
    private static final float VIEWPORT_WIDTH = 40f;
    private static final float VIEWPORT_HEIGHT = 40f;
    private static final float TIME_STEP = 1/120f;
    private SpriteBatch batch;
    private static Camera camera;
    private static World world;
    private Box2DDebugRenderer debugRenderer;
    private KeyboardInput keyboardInput;
    private static AllEntities allEntities;
    private static AllEvents allEvents;

    @Override
    public void create() {
        GameService.setInstance(this);
        Box2D.init();
        batch = new SpriteBatch();
        createCamera();
        debugRenderer = new Box2DDebugRenderer();
        world = new World(Vector2.Zero, true);
        Entity player = Player.createPlayer("player.xml");
        keyboardInput = new KeyboardInput();
        allEntities = new AllEntities();
        allEntities.setPlayer(player);
        allEvents = new AllEvents();
        BodyFactory.createBounds(null);
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
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        getCamera().update();
        batch.setProjectionMatrix(getCamera().combined);
        debugRenderer.render(world, getCamera().combined);
        batch.begin();
        for(Entity entity : allEntities.getEntityList()) {
            entity.display(batch);
        }
        batch.end();
    }
    private void update(){
        Player player = allEntities.getPlayer();
        keyboardInput.processInput(player);
        MouseInput.processInput(player);

        for(Entity entity : allEntities.getEntityList()) {
            entity.update();
        }
        allEvents.executeEvents();
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

    public Camera getCamera() {
        return camera;
    }

    public World getWorld(){
        return world;
    }

    public AllEntities getAllEntities(){
        return allEntities;
    }

    public AllEvents getAllEvents() {
        return allEvents;
    }

}
