package com.scarlett.game.core.entity.bullet;

import com.scarlett.game.core.entity.EntityDescriptor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bullet")
public class BulletDescriptor {
    @XmlElement(name = "entity")
    private EntityDescriptor entity;
    @XmlElement(name = "damage")
    private int damage;
    @XmlElement(name = "damage-type")
    private int damageType;

    public BulletDescriptor(){
        entity = null;
        damage = 0;
        damageType = 0;
    }

    public BulletDescriptor(EntityDescriptor entity, int damage, int damageType) {
        this.entity = entity;
        this.damage = damage;
        this.damageType = damageType;
    }

    public EntityDescriptor getEntity() {
        return entity;
    }

    public int getDamage() {
        return damage;
    }

    public int getDamageType() {
        return damageType;
    }
}
