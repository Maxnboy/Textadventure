package com.company;

import java.util.ArrayList;

public class Spieler implements Container {
    String name = "Artus";
    Raum aktuellerRaum = null;


    public Spieler(Raum raum) {
        aktuellerRaum = raum;
    }

    public String toString() {
        return name + ":\n\tAktueller Raum:\t" + aktuellerRaum + "\n\tInventar: " + dinge;
    }

    public void take(Ding ding) {
        if (ding.istStatic) {
            System.out.println("Das Ding ist zu schwer");
        } else {
            dinge.add(ding);
            aktuellerRaum.rmDing(ding);
        }
    }

    //FIXME
    public void open(Truhe truhe) {
        System.out.println(truhe.toString());
    }

    public void setAktuellerRaum(String key, Raum raum) {
        if (raum == this.aktuellerRaum) {
            //Exeption
            System.out.println("Ich bin hier schon");
        } else {
            if (aktuellerRaum.getNachbarraeume().get(key) == null) {
                //Exeption
                System.out.println("Raum kein Zugang");
            } else {
                aktuellerRaum = raum;
                System.out.println(name + " ist jetzt im " + this.aktuellerRaum.name);
            }
        }
    }
}
