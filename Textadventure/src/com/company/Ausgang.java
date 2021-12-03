package com.company;

public class Ausgang extends Entitaet {
    Raum Raum1 = null;
    Raum Raum2 = null;

    public Ausgang(String name, String beschreibung, Raum Raum1, Raum Raum2) {
        super(name, beschreibung);
        this.Raum1 = Raum1;
        this.Raum2 = Raum2;

        Raum1.addAusgang(this);
        Raum2.addAusgang(this);
    }

}
