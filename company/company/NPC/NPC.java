package com.company.NPC;

import com.company.Entitity;
import com.company.Key;
import com.company.Room;

public class NPC extends Entitity {

    private Key key;
    private Room currentRoom;
    private final Voiceline voiceline;
    
    
    public NPC(String name, String description, Room room, Key key, Voiceline voiceline) {

        
        super(name, description);
        this.currentRoom = room;
        this.key = key;
        this.voiceline = voiceline;

        currentRoom.addItem(this);
    }

    public String talk () {

        return voiceline.talking();

    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Key getKey() {
        return key;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setKey(Key key) {
        this.key = key;
    }

}








































