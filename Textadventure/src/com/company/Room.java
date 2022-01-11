package com.company;

import com.company.exceptions.GivenKeyIsNotNeededKeyException;
import com.company.exceptions.RoomIsNotLockedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Room extends Entitity implements Container {



    private ArrayList<Entitity> roomInventory = new ArrayList<>();
    private final HashMap<String, Room> nearbyRoom = new HashMap<>();
    private boolean isLocked;
    private Key neededKey;
    private Location location;
    private Event event = null;

    public Room(String name, String description, Location location, boolean isLocked, boolean isstaion) {

        super(name, description);
        this.isLocked = isLocked;
        this.location = location;
        this.location.getLocationrooms().add(this);

        if (isstaion) {
            location.setStation(this);
        }

    }

    public Room(String name, String description, Location location, boolean isstaion) {
        super(name, description);
        this.location = location;
        this.location.getLocationrooms().add(this);

        if (isstaion) {
            location.setStation(this);
        }

    }

    public void addNearbyRoom(String direction, Room room) {
        nearbyRoom.put(direction, room);
    }

    /*

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
        for (Entitity ding :
                roomInventory) {
            ret = ret + ding.name + "\t,";
        }
        return ret;
    }

    */

    public HashMap<String, Room> nearbyRoom() {
        return nearbyRoom;
    }

    @Override
    public void rmItem(Entitity item) {
        roomInventory.remove(item);
    }

    @Override
    public void addItem(Entitity item) {
        roomInventory.add(item);
    }

    public void unlock(Key key) {

        if (!isLocked) {

            try {
                throw new RoomIsNotLockedException();
            }catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }else if(neededKey == key) {

            isLocked = false;
            System.out.println("The room "+name+" has been unlocked.");

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

    public ArrayList<Entitity> getRoomInventory() {
        return roomInventory;
    }

    public HashMap<String, Room> getNearbyRoom() {
        return nearbyRoom;
    }

    public Location getLocation() {
        return location;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return name +"\n\t\tdesc: "+ description;
    }

}