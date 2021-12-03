package com.company;

public class NPC extends Entitity {
    //non playable character
    //TODO NPC
    //FIXME
    
    Key key;
    Room currentRoom;

    public NPC(String name, String description, Room room, Key key) {
        
        super(name, description);
        this.currentRoom = room;
        this.key = key;

    }


}
