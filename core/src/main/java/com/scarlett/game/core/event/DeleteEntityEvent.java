package com.scarlett.game.core.event;

import com.scarlett.game.core.ScarlettStationGame;
import com.scarlett.game.core.entity.Entity;

public class DeleteEntityEvent extends Event {
    private final Entity entity;

    public DeleteEntityEvent(Entity entity) {
        this.entity = entity;
    }

    @Override
    public void execute() {
        entity.agony();
        ScarlettStationGame.getAllEntities().deleteEntity(entity);
    }
}
