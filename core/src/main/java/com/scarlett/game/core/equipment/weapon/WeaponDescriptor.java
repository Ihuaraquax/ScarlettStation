package com.scarlett.game.core.equipment.weapon;

import com.scarlett.game.core.entity.bullet.BulletDescriptor;
import com.scarlett.game.core.sound.SoundDescriptor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "weapon")
public class WeaponDescriptor {
    @XmlElement(name = "damage")
    private int damage;
    @XmlElement(name = "ammo-max")
    private int ammoMax;
    @XmlElement(name = "cooldown")
    private float cooldown;
    @XmlElement(name = "reload-time")
    private float reloadTime;
    @XmlElement(name = "sound")
    private List<SoundDescriptor> sounds;
    @XmlElement(name = "shooting-sound-id")
    private int shootingSoundId;
    @XmlElement(name = "bullet")
    private BulletDescriptor bulletDescriptor;

    public WeaponDescriptor(){
        this.damage = 0;
        this.ammoMax = 0;
        this.cooldown = 0;
        this.reloadTime = 0;
        sounds = null;
        shootingSoundId = 0;
        bulletDescriptor = null;
    }

    public WeaponDescriptor(int damage, int ammoMax, float cooldown, float reloadTime, List<SoundDescriptor> sounds, int shootingSoundId, BulletDescriptor bulletDescriptor) {
        this.damage = damage;
        this.ammoMax = ammoMax;
        this.cooldown = cooldown;
        this.reloadTime = reloadTime;
        this.sounds = sounds;
        this.shootingSoundId = shootingSoundId;
        this.bulletDescriptor = bulletDescriptor;
    }

    public int getDamage() {
        return damage;
    }

    public int getAmmoMax() {
        return ammoMax;
    }

    public float getCooldown() {
        return cooldown;
    }

    public float getReloadTime() {
        return reloadTime;
    }

    public List<SoundDescriptor> getSounds() {
        return sounds;
    }

    public int getShootingSoundId() {
        return shootingSoundId;
    }

    public BulletDescriptor getBulletDescriptor() {
        return bulletDescriptor;
    }
}
