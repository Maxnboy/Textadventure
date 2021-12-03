package com.company;

import java.util.ArrayList;

public class Chest extends Item implements Container {

    ArrayList<Item> chestInventory = new ArrayList<>();

    public Chest(String name, String description, boolean isStatic, Room room) {
        super(name, description, isStatic, room);
        chestInventory.clear();
    }

    @Override
    public String toString() {
        return super.toString(); // + dinge.toString();
    }

    @Override
    public void rmItem(Item item) {
        chestInventory.remove(item);
    }

    @Override
    public void addItem(Item item) {
        chestInventory.add(item);
    }
}
