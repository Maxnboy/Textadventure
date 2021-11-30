package com.company;

import java.util.ArrayList;

public class Ding extends Entitaet {
    Container aktuellerContainer = null;
    boolean istStatic;

    public Ding(String name, String beschreibung, boolean istStatic) {
        super(name, beschreibung);
        this.istStatic = istStatic;
    }

}
