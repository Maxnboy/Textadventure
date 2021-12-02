package com.company;

import java.util.ArrayList;

public class Truhe extends Ding implements Container{

    public Truhe(String name, String beschreibung, boolean istStatic) {
        super(name, beschreibung, istStatic);
        dinge.clear();
    }

    @Override
    public String toString() {
        return super.toString(); // + dinge.toString();
    }
}
