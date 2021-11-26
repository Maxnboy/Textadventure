package com.company;

public class Main {

    public static void main(String[] args) {

        Raum dach = new Raum("Dach", "Dies ist das Dach der kleinen Hütte.");
        Raum huette = new Raum("Hütte", "Dies ist eine kleine, verfallene Hütte am Waldrand.");
        Raum wiese = new Raum("Wiese", "Eine Wildblumenwiese. Irgendetwas ist seltsam an dieser Wiese.");
        Raum bach = new Raum("Bach", "Ein reißender Bergbach. Ein falscher Schritt kann dich das Leben kosten...");

        Spieler artus = new Spieler(bach);

        Ding schwert = new Ding("Schwert", "Ein königliches Schwert", false);

        Truhe truhe = new Truhe("Truhe", "erste Truhe", true);

        truhe.addDing(schwert);

        bach.addDing(truhe);

        artus.take(truhe);

        artus.open(truhe);

        System.out.println(dach.toString());
        System.out.println(huette.toString());
        System.out.println(wiese.toString());
        System.out.println(bach.toString());
        System.out.println(artus.toString());

    }
}
