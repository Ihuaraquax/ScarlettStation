package com.scarlett.game.core.entity;

import javax.xml.bind.annotation.XmlElement;

public class DamageResistancesDescriptor {
    @XmlElement(name = "fire")
    private int fire;
    @XmlElement(name = "frost")
    private int frost;
    @XmlElement(name = "electricity")
    private int electricity;
    @XmlElement(name = "explosives")
    private int explosives;
    @XmlElement(name = "normal")
    private int normal;

    public DamageResistancesDescriptor() {
        this.fire = 0;
        this.frost = 0;
        this.electricity = 0;
        this.explosives = 0;
        this.normal = 0;
    }

    public DamageResistancesDescriptor(int fire, int frost, int electricity, int explosives, int normal) {
        this.fire = fire;
        this.frost = frost;
        this.electricity = electricity;
        this.explosives = explosives;
        this.normal = normal;
    }

    public int getNormal() {
        return normal;
    }

    public int getExplosives() {
        return explosives;
    }

    public int getElectricity() {
        return electricity;
    }

    public int getFrost() {
        return frost;
    }

    public int getFire() {
        return fire;
    }
}
