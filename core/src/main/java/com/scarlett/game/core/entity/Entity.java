package com.scarlett.game.core.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.scarlett.game.core.GameService;
import com.scarlett.game.core.ScarlettStationGame;
import com.scarlett.game.core.animation.Animation;
import com.scarlett.game.core.animation.AnimationDescriptor;
import com.badlogic.gdx.physics.box2d.Body;
import com.scarlett.game.core.equipment.Equipment;
import com.scarlett.game.core.equipment.weapon.Weapon;
import com.scarlett.game.core.equipment.weapon.WeaponDescriptor;
import com.scarlett.game.core.event.DeleteEntityEvent;
import com.scarlett.game.core.event.Event;
import com.scarlett.game.core.utils.BodyFactory;

public class Entity {
    private static final float DISPLAY_SCALE = 1/32f;
    protected Animation idleAnimation;
    protected Animation walkAnimation;
    protected Animation shootAnimation;
    protected Animation deathAnimation;
    protected Attributes attributes;
    protected EntityState state;
    protected Body body;
    protected boolean stopping = true;
    protected float speedX;
    protected float speedY;
    private Equipment weapon = null;

    public Entity(EntityDescriptor descriptor, Vector2 position){
        assignAnimations(descriptor);
        attributes = new Attributes(descriptor.getAttributes());
        state = EntityState.IDLE;
        float width = descriptor.getAttributes().getWidth();
        float height = descriptor.getAttributes().getWidth();
        body = BodyFactory.createRectangularBody(position.x, position.y, height/3, width/3, this);
        assignWeapons(descriptor);
    }

    private void assignWeapons(EntityDescriptor descriptor){
        if(descriptor.getWeapons() != null) {
            WeaponDescriptor weaponDescriptor = descriptor.getWeapons().get(0);
            if (weaponDescriptor != null) {
                weapon = new Weapon(this, weaponDescriptor);
            }
        }
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void update(){
        if(weapon != null) {
            weapon.update();
        }
        body.setLinearVelocity(new Vector2(speedX, speedY));
        if(stopping) {
            speedX = 0;
            speedY = 0;
        }
        specificUpdate();
        if(attributes.getHealth() <= 0){
            Event deleteEntity = new DeleteEntityEvent(this);
            GameService.getInstance().getAllEvents().addEvent(deleteEntity);
        }
    }

    protected void specificUpdate(){

    }

    public void display(SpriteBatch batch){
        TextureRegion region = null;
        switch (state){
            case IDLE:
                region = idleAnimation.getCurrentRegion();
                break;
            case WALKING:
                region = walkAnimation.getCurrentRegion();
                break;
            case SHOOTING:
                region = shootAnimation.getCurrentRegion();
                break;
            case DYING:
                region = deathAnimation.getCurrentRegion();
                break;
        }
        float imageWidth = region.getRegionWidth();
        float imageHeight = region.getRegionHeight();
        float imageCenterX = imageWidth/2;
        float imageCenterY = imageHeight/2;
        // nie bardzo rozumiem dlaczego, ale dziala
        float x = body.getPosition().x - imageCenterX;
        float y = body.getPosition().y - imageCenterY;
        float angle = getAngle();

        batch.draw(region, x, y, imageCenterX, imageCenterY, imageWidth, imageHeight, DISPLAY_SCALE, DISPLAY_SCALE, angle);
    }

    public void move(int horizontal, int vertical){
        if(horizontal != 0) {
            speedX = attributes.getSpeed() * horizontal;
        }
        if(vertical != 0) {
            speedY = attributes.getSpeed() * vertical;
        }
        state = EntityState.WALKING;
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

    public void agony(){

    }

    public void shoot(){
        weapon.use();
    }

    public Vector2 getPosition() {
        return body.getPosition();
    }

    public float getAngle(){
        return body.getAngle() * MathUtils.radiansToDegrees;
    }
}
