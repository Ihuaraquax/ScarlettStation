package com.scarlett.game.core.equipment.weapon;

import com.badlogic.gdx.Gdx;
import com.scarlett.game.core.entity.Entity;
import com.scarlett.game.core.equipment.Equipment;
import com.scarlett.game.core.equipment.EquipmentType;
import com.scarlett.game.core.sound.Sound;
import com.scarlett.game.core.sound.SoundDescriptor;

public class Weapon extends Equipment{
    private WeaponDescriptor descriptor;
    private float time = 0;
    private boolean reloaded;
    private int ammoLeft;
    private Sound shootingSound;

    public Weapon(Entity wielder, WeaponDescriptor descriptor) {
        super(wielder, EquipmentType.WEAPON);
        this.descriptor = descriptor;
        this.reloaded = true;
        ammoLeft = descriptor.getAmmoMax();
        assignSounds(descriptor);
    }

    @Override
    public void update(){
        if(time > 0){
            time -= Gdx.graphics.getDeltaTime();
        }
        if(time < 0){
            time = 0;
            if(!reloaded) {
                reloaded = true;
                ammoLeft = descriptor.getAmmoMax();
            }
        }
    }

    @Override
    public void use(){
        if(reloaded){
            shootingSound.playSound();
            ammoLeft--;
            if(ammoLeft <= 0){
                time = descriptor.getReloadTime();
                reloaded = false;
            } else {
                time = descriptor.getCooldown();
            }
        }
    }

    private void assignSounds(WeaponDescriptor descriptor){
        for (SoundDescriptor soundDescriptor : descriptor.getSounds()){
            Sound sound = new Sound(soundDescriptor);
            if(soundDescriptor.getId() == descriptor.getShootingSoundId()){
                shootingSound = sound;
            }
        }
    }
}
