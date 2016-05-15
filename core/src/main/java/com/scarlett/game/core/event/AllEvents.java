package com.scarlett.game.core.event;

import java.util.ArrayList;
import java.util.List;

public class AllEvents {
    private List<Event> events;
    public AllEvents(){
        events = new ArrayList<Event>();
    }

    public void addEvent(Event event){
        events.add(event);
    }

    public void executeEvents(){
        for(Event event : events){
            event.execute();
        }
        events.clear();
    }
}
