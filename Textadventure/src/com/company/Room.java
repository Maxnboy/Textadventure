package com.company;

import com.company.exceptions.GivenKeyIsNotNeededKeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Room extends Entitity implements Container {

    ArrayList<Item> roomInventory = new ArrayList<>();
    private final HashMap<String, Room> nearbyRoom = new HashMap<>();
    private boolean isLocked = false;
    private Key neededKey;

    public Room(String name, String description, boolean isLocked) {
        
        super(name, description);
        this.isLocked = isLocked;
        
    }

    public Room(String name, String description) {
        super(name, description);
    }

    public void addNearbyRoom(String direction, Room room) {
        nearbyRoom.put(direction, room);
    }

    @Override
    public String toString() {
        String ret = super.toString() + "\n";
        Iterator<Map.Entry<String, Room>> iterator = nearbyRoom.entrySet().iterator();
        if (iterator.hasNext()) {
            ret = ret + "\tNachbarn: ";
        }
        while (iterator.hasNext()) {
            ret = ret + nearbyRoom.get(iterator.next().getKey()).getName() + "\t";
        }
        if (!roomInventory.isEmpty()) {
            ret = ret + "\n\tContained Items: ";
        }
        for (Item ding :
                roomInventory) {
            ret = ret + ding.name + "\t";
        }
        return ret;
    }


    public HashMap<String, Room> nearbyRoom() {
        return nearbyRoom;
    }

    @Override
    public void rmItem(Item item) {
        roomInventory.remove(item);
    }

    @Override
    public void addItem(Item item) {
        roomInventory.add(item);
    }

    
    @Deprecated //FIXME
    public void unlock(Key key) {
        
        if(neededKey == key) {
            isLocked = false;
        }else{
            
            try {
                throw new GivenKeyIsNotNeededKeyException();
            }catch (Exception e) {
                System.err.println(e.getMessage());
            }
            
            
        }
        
    }
    
    
    public void setNeededKey(Key neededKey) {
        this.neededKey = neededKey;
    }
    
}