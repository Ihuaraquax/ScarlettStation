package com.scarlett.game.core.event;

import com.scarlett.game.core.GameService;
import com.scarlett.game.core.ScarlettStationGame;
import com.scarlett.game.core.entity.Entity;

public class CreateEntityEvent extends Event{
    private final Entity entity;

    public CreateEntityEvent(Entity entity){
        this.entity = entity;
    }

    @Override
    public void execute() {
        GameService.getInstance().getAllEntities().addEntity(entity);
    }
}
