package com.scarlett.game.core.entity.allentities;

import com.scarlett.game.core.entity.Entity;
import com.scarlett.game.core.entity.player.Player;

import java.util.ArrayList;
import java.util.List;

public class AllEntities {
    private List<Entity> entityList;
    private Entity player;

    public AllEntities(){
        entityList = new ArrayList<Entity>();
        player = null;
    }

    public List<Entity> getEntityList(){
        return entityList;
    }

    public void addEntity(Entity entity){
        entityList.add(entity);
    }

    public void deleteEntity(Entity entity){
        entityList.remove(entity);
    }

    public Player getPlayer(){
        return (Player) player;
    }

    public void setPlayer(Entity player){
        this.player = player;
        addEntity(player);
    }
}
