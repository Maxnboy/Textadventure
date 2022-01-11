package com.company;

public class Item extends Entitity {
    Container currentContainer = null;
    boolean isStatic;

    public Item(String name, String description, boolean isStatic, Room room) {
        super(name, description);
        this.isStatic = isStatic;
        room.addItem(this);
    }
}
