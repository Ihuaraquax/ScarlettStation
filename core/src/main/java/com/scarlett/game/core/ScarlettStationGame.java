package com.scarlett.game.core;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.scarlett.game.core.animation.Animation;

public class ScarlettStationGame implements ApplicationListener {
    Animation animation;
    SpriteBatch batch;
    float elapsed;

    @Override
    public void create() {
        animation = Animation.createAnimation("animationdescriptor.xml");
        batch = new SpriteBatch();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {
        TextureRegion texture = animation.getCurrentRegion();
        elapsed += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(texture, 100 + 100 * (float) Math.cos(elapsed), 100 + 25 * (float) Math.sin(elapsed));
        batch.end();
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
