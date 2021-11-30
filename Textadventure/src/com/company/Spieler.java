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

    public void setAktuellerRaum(Raum raum) {
        if (raum == aktuellerRaum) {
            //Exeption
        } else {
            for (Ausgang ausgang :
                    this.aktuellerRaum.getAusgaenge()) {
                if (ausgang.Raum1 == raum || ausgang.Raum2 == raum) {
                    aktuellerRaum = raum;
                    System.out.println(this.name + " ist im " + this.aktuellerRaum);
                    return;
                }
            }
            System.out.println("Raum zu weit weg!");
        }
    }
}
