
package com.company;

public class Main {

    public static void main(String[] args) {

        //TODO NPC

        Room roof = new Room("Roof", "This is the roof of the small hut.");
        Room hut = new Room("Hut", "Dies ist eine kleine, verfallene Hütte am Waldrand.");
        Room field = new Room("Field", "Eine Wildblumenwiese. Irgendetwas ist seltsam an dieser Wiese.");
        Room river = new Room("River", "Ein reißender Bergbach. Ein falscher Schritt kann dich das Leben kosten...");
        Player artus = new Player(hut);

        //Objective: escape room, Schnitzeljagd, Escape britain!!!!


    }
}
