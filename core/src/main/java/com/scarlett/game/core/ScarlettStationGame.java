package com.scarlett.game.core;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.scarlett.game.core.animation.Animation;
import com.scarlett.game.core.entity.Entity;
import com.scarlett.game.core.sound.Sound;

public class ScarlettStationGame implements ApplicationListener {
    private SpriteBatch batch;
    private Entity entity;

    @Override
    public void create() {
        batch = new SpriteBatch();
        entity = Entity.createEntity("entity.xml");
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
        batch.begin();
        entity.display(batch);
        batch.end();
    }
    private void update(){
        entity.update();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
