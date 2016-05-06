package com.scarlett.game.core.entity;

import javax.xml.bind.annotation.XmlElement;

public class AttributesDescriptor {
    @XmlElement(name = "health")
    private int health;
    @XmlElement(name = "speed")
    private float speed;
    @XmlElement(name = "width")
    private float width;
    @XmlElement(name = "height")
    private float height;
    @XmlElement(name = "armor")
    private int armor;
    @XmlElement(name = "damage-resistances")
    private DamageResistancesDescriptor damageResistancesDescriptor;
    @XmlElement(name = "collision-mask-bit")
    private short collisionMaskBit;
    @XmlElement(name = "collision-category-bit")
    private short collisionCategoryBit;
    @XmlElement(name = "entity-type")
    private int entityType;

    public AttributesDescriptor() {
        this.health = 0;
        this.speed = 0;
        this.width = 0;
        this.height = 0;
        this.armor = 0;
        this.damageResistancesDescriptor = null;
        this.collisionMaskBit = 0;
        this.collisionCategoryBit = 0;
        this.entityType = 0;
    }

    public AttributesDescriptor(int health, float speed, float width, float height, int armor,
                                DamageResistancesDescriptor damageResistancesDescriptor, short collisionMaskBit,
                                short collisionCategoryBit, int entityType) {
        this.health = health;
        this.speed = speed;
        this.width = width;
        this.height = height;
        this.armor = armor;
        this.damageResistancesDescriptor = damageResistancesDescriptor;
        this.collisionMaskBit = collisionMaskBit;
        this.collisionCategoryBit = collisionCategoryBit;
        this.entityType = entityType;
    }

    public int getEntityType() {
        return entityType;
    }

    public short getCollisionCategoryBit() {
        return collisionCategoryBit;
    }

    public short getCollisionMaskBit() {
        return collisionMaskBit;
    }

    public DamageResistancesDescriptor getDamageResistancesDescriptor() {
        return damageResistancesDescriptor;
    }

    public int getArmor() {
        return armor;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }
}
