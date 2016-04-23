package com.scarlett.game.core.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {
    private AnimationDescriptor descriptor;
    private Array<TextureRegion> regions;
    private int currentTile = 0;
    private float timeElapsed;
    private AnimationType type;
    private boolean changeFrame = true;
    private int direction = 1;

    public Animation(AnimationDescriptor descriptor) {
        this.descriptor = descriptor;
        regions = new Array<TextureRegion>();
        Texture texture = new Texture(Gdx.files.internal(descriptor.getDirectory()));
        TextureRegion region[][] = TextureRegion.split(texture, descriptor.getWidth(), descriptor.getHeight());
        for (TextureRegion[] row : region) {
            for (TextureRegion tile : row) {
                regions.add(tile);
            }
        }
        type = AnimationType.getByCode(descriptor.getType());
    }

    public static Animation createAnimation(String descriptorPath) {
        AnimationDescriptor descriptor = AnimationDescriptor.getFromFile(descriptorPath);
        Animation animation = new Animation(descriptor);
        return animation;
    }

    public TextureRegion getCurrentRegion() {
        TextureRegion result = regions.get(currentTile);
        increaseCurrentTile();
        return result;
    }

    private void increaseCurrentTile() {
        switch (type) {
            case NORMAL:
                changeFrameForNormal();
                break;
            case SINGLE:
                changeFrameForSingle();
                break;
            case REVERSE:
                changeFrameForReverse();
                break;
            case STATIC:
                break;
        }
    }

    private void changeFrameForNormal() {
        timeElapsed += Gdx.graphics.getDeltaTime();
        if (timeElapsed > descriptor.getSpeed()) {
            timeElapsed = 0;
            currentTile++;
        }
        if (currentTile >= regions.size) {
            currentTile = 0;
        }

    }

    private void changeFrameForSingle() {
        if (changeFrame) {
            timeElapsed += Gdx.graphics.getDeltaTime();
            if (timeElapsed > descriptor.getSpeed()) {
                timeElapsed = 0;
                currentTile++;
            }
            if (currentTile >= regions.size) {
                currentTile = 0;
                changeFrame = false;
            }
        }
    }

    private void changeFrameForReverse() {
        timeElapsed += Gdx.graphics.getDeltaTime();
        if (timeElapsed > descriptor.getSpeed()) {
            timeElapsed = 0;
            currentTile += direction;
        }
        if (currentTile >= regions.size) {
            currentTile--;
            direction *= -1;
        }
        if (currentTile < 0) {
            currentTile++;
            direction *= -1;
        }
    }
}
