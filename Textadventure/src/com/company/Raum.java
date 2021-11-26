package com.company;

import java.util.ArrayList;

public class Raum extends Entitaet implements Container{

    private ArrayList<Ausgang> Ausgaenge = new ArrayList<>();

    public Raum(String name, String beschreibung) {
        super(name, beschreibung);
    }

    public void addAusgang(Ausgang ausgang) {

        Ausgaenge.add(ausgang);
    }
}
