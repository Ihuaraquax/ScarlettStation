package com.scarlett.game.core.entity;

public class Attributes {
    private int health;
    private float speed;
    private float width;
    private float height;
    private int armor;
    private Resistances resistances;
    private short maskBits;
    private short categoryBits;
    private int entityType;


    public Attributes(AttributesDescriptor descriptor){
        this.health = descriptor.getHealth();
        this.speed = descriptor.getSpeed();
        this.width = descriptor.getWidth();
        this.height = descriptor.getHeight();
        this.armor = descriptor.getArmor();
        this.resistances = new Resistances(descriptor.getDamageResistancesDescriptor());
        this.maskBits = descriptor.getCollisionMaskBit();
        this.categoryBits = descriptor.getCollisionCategoryBit();
        this.entityType = descriptor.getEntityType();
    }
}
