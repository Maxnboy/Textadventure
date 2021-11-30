package com.company;

import java.util.ArrayList;

public class Spieler implements Container{
    String name = "Artus";
    Raum aktuellerRaum = null;

    public Spieler(Raum raum) {
        aktuellerRaum = raum;
    }

    public String toString() {
        return name + ":\n\tAktueller Raum:\t" + aktuellerRaum + "\n\tInventar: " + Inventar;
    }

    public void take(Ding ding) {
        if (ding.istStatic) {
            System.out.println("Das Ding ist zu schwer");
        } else {
            ding.add(ding);
        }
    }

    public void open(Truhe truhe) {
        System.out.println(truhe.dinge);
    }
}
