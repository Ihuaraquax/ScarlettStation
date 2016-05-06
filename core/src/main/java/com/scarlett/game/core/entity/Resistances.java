package com.scarlett.game.core.entity;

public class Resistances {
    private int normal;
    private int fire;
    private int frost;
    private int electicity;
    private int explosives;

    public Resistances(DamageResistancesDescriptor descriptor){
        this.fire = descriptor.getFire();
        this.frost = descriptor.getFrost();
        this.electicity = descriptor.getElectricity();
        this.explosives = descriptor.getExplosives();
        this.normal = descriptor.getNormal();
    }

    public int getNormal() {
        return normal;
    }

    public int getFire() {
        return fire;
    }

    public int getFrost() {
        return frost;
    }

    public int getElecticity() {
        return electicity;
    }

    public int getExplosives() {
        return explosives;
    }
}
