package com.scarlett.game.core.equipment;

import com.scarlett.game.core.entity.Entity;

public abstract class Equipment {
    private Entity wielder;
    private final EquipmentType type;

    public Equipment(Entity wielder, EquipmentType type){
        this.wielder = wielder;
        this.type = type;
    }

    public void update(){

    }

    public void use(){

    }

    public EquipmentType getType() {
        return type;
    }
}
