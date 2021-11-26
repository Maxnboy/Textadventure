package com.company;

import java.util.ArrayList;

public abstract class Entitaet {
    String name;
    String beschreibung;

    public Entitaet(String name, String beschreibung) {
        this.name = name;
        this.beschreibung = beschreibung;
    }

    public String toString() {
        return name + ":\t" + beschreibung;
    }
}
