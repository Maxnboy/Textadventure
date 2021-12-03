package com.company;

import com.company.exceptions.CurrentRoomIsTargetRoomException;
import com.company.exceptions.RoomIsNotNeighbouringException;

import java.util.ArrayList;

public class Player implements Container {
    String name = "Artus";
    Room currentRoom;
    ArrayList<Item> inventory = new ArrayList<>();

    public Player(Room raum) {
        currentRoom = raum;
    }

    public String toString() {
        return name + ":\n\tCurrent room:\t" + currentRoom + "\n\tinventory: " + inventory;
    }

    public void take(Item item) {
        
        if (item.isStatic) {
            
            System.out.println("The item is too heavy");
            
        } else {
            
            inventory.add(item);
            currentRoom.rmItem(item);
            
        }
        
    }

    //FIXME
    public void open(Chest truhe) {
        System.out.println(truhe.toString());
    }

    public void setCurrentRoom(String key, Room room) {
        
        if (room == this.currentRoom) {

            try {
                
                throw new CurrentRoomIsTargetRoomException();
                
            } catch (Exception e) {
                
                System.err.println(e.getMessage());
                
            }

        } else {
            
            if (currentRoom.nearbyRoom().get(key) == null) {

                try {
                    
                    throw new RoomIsNotNeighbouringException();
                    
                } catch (Exception e) {
                    
                    System.err.println(e.getMessage());
                    
                }

            } else {
                
                currentRoom = room;
                System.out.println(this.name + " is now in " + this.currentRoom.name);
                
            }
            
        }
        
    }

    @Override
    public void rmItem(Item ding) {
        inventory.remove(ding);
    }

    @Override
    public void addItem(Item ding) {
        inventory.add(ding);
    }
}
