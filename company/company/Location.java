package com.company;

import com.company.exceptions.GivenKeyIsNotNeededKeyException;
import com.company.exceptions.RoomIsNotLockedException;

import java.util.ArrayList;
import java.util.HashMap;

public class Location extends Entitity implements Container{

    private ArrayList<Entitity> locationInventory = new ArrayList<>();
    private ArrayList<Room> locationrooms = new ArrayList<>();
    private final HashMap<String, Location> nearbyLocation = new HashMap<>();
    private boolean isLocked = false;
    private Key neededKey;
    private Room station;


    public Location(String name, String description, boolean isLocked) {
        super(name, description);
        this.isLocked = isLocked;
    }

    public Location(String name, String description) {
        super(name, description);
    }

    @Override
    public void rmItem(Entitity item) {
        locationInventory.remove(item);
    }

    @Override
    public void addItem(Entitity item) {
        locationInventory.add(item);
    }

    public void addNearbyLocation(String direction, Location location) {
        nearbyLocation.put(direction, location);
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

        }else{

            try {
                throw new GivenKeyIsNotNeededKeyException();
            }catch (Exception e) {
                System.err.println(e.getMessage());
            }


        }

    }

    public HashMap<String, Location> getNearbyLocation() {
        return nearbyLocation;
    }

    public ArrayList<Room> getLocationrooms() {
        return locationrooms;
    }

    public void setStation(Room station) {
        this.station = station;
    }

    public Room getStation() {
        return station;
    }

    @Override
    public String toString() {
        return name +"\n\t\tdesc: "+ description;
    }

}
