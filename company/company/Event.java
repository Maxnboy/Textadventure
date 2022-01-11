package com.company;

import com.company.NPC.NPC;

public class Event {
    private final Room room;
    private final NPC npc;
    private final String event;
    private String[] options;

    public Event(Room room, NPC npc, String event, String[] options) {
        this.room = room;
        this.npc = npc;
        this.event = event;
        this.options = options;
        room.setEvent(this);
    }

    public void setOp() {

    }

    public void trigger(int choice) {



    }

    public NPC getNpc() {
        return npc;
    }

    public Room getRoom() {
        return room;
    }

    public String getEvent() {
        return event;
    }

    public String[] getOptions() {
        return options;
    }
}

