package com.scarlett.game.core.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.scarlett.game.core.animation.Animation;
import com.scarlett.game.core.animation.AnimationDescriptor;

public class Entity {
    private Animation idleAnimation;
    private Animation walkAnimation;
    private Animation shootAnimation;
    private Animation deathAnimation;
    private Attributes attributes;
    private EntityState state;
    private Coordinates coordinates;

    public Entity(EntityDescriptor descriptor){
        System.out.print(descriptor.getAnimations().size());
        assignAnimations(descriptor);
        attributes = new Attributes(descriptor.getAttributes());
        state = EntityState.IDLE;
        coordinates = new Coordinates(10, 10, 0, 0);
    }

    public static Entity createEntity(String filepath){
        EntityDescriptor descriptor = EntityDescriptor.getFromFile(filepath);
        return new Entity(descriptor);
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void update(){
        coordinates.update();
    }

    public void display(SpriteBatch batch){
        float x = coordinates.getX();
        float y = coordinates.getY();
        switch (state){
            case IDLE:
                batch.draw(idleAnimation.getCurrentRegion(),x ,y);
                break;
            case WALKING:
                batch.draw(walkAnimation.getCurrentRegion(),x ,y);
                break;
            case SHOOTING:
                batch.draw(shootAnimation.getCurrentRegion(),x ,y);
                break;
            case DYING:
                batch.draw(deathAnimation.getCurrentRegion(),x ,y);
                break;
        }
    }

    private void assignAnimations(EntityDescriptor descriptor){
        int idleId = descriptor.getIdleAnimationId();
        int walkId = descriptor.getWalkAnimationId();
        int shootId = descriptor.getShootAnimationId();
        int deathId = descriptor.getDeathAnimationId();
        for(AnimationDescriptor animationDescriptor : descriptor.getAnimations()){
            Animation animation = new Animation(animationDescriptor);
            if(idleId == animationDescriptor.getId()){
                idleAnimation = animation;
            }
            if(walkId == animationDescriptor.getId()){
                walkAnimation = animation;
            }
            if(shootId == animationDescriptor.getId()){
                shootAnimation = animation;
            }
            if(deathId == animationDescriptor.getId()){
                deathAnimation = animation;
            }
        }
    }
}
