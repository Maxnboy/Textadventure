package com.company;

import com.company.exceptions.CurrentRoomIsTargetRoomException;
import com.company.exceptions.ItemIsStaticException;
import com.company.exceptions.RoomIsNotNeighbouringException;

import java.util.ArrayList;
import java.util.Scanner;

public class Player implements Container {
    private String name = "Artus";
    private Room currentRoom;
    private Location currentLocation;
    private ArrayList<Entitity> inventory = new ArrayList<>();

    public Player(Room raum) {
        System.out.println("You wake up in a mysterious field without knowing where you are and how you got there...");
        currentRoom = raum;
        currentLocation = raum.getLocation();

    }

    public String toString() {
        return name + ":\n\tCurrent room:\t" + currentRoom + "\n\tinventory: " + inventory;
    }

    public void take(Item item) {

        if (item.isStatic) {

            try {
                throw new ItemIsStaticException();
            }catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } else {

            inventory.add(item);
            currentRoom.rmItem(item);

        }

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
    public void rmItem(Entitity ding) {
        inventory.remove(ding);
    }

    @Override
    public void addItem(Entitity ding) {
        inventory.add(ding);
    }

    public ArrayList<Entitity>  getInventory() {
        return inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void move (Room room) {

        if (currentRoom.getLocation() == room.getLocation()) {

            currentRoom = room;

        }else {

            if (currentRoom == currentLocation.getStation() && room == room.getLocation().getStation()) {

                currentRoom = room;
                currentLocation = room.getLocation();

            }


            try {
                throw new RoomIsNotNeighbouringException();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println("You are now in the Room: "+getCurrentRoom().getName()+"\n");


    }

}
