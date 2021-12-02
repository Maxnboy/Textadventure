package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Raum extends Entitaet implements Container{

    private HashMap<String, Raum> Nachbarraeume = new HashMap<>();


    public Raum(String name, String beschreibung) {
        super(name, beschreibung);
    }

    public void addNachbarraum(String richtung, Raum raum) {
        Nachbarraeume.put(richtung, raum);
    }

    @Override
    public String toString() {
        String ret = super.toString() + "\n\tNachbarn: ";
        Iterator<Map.Entry<String, Raum>> iterator = Nachbarraeume.entrySet().iterator();
        while(iterator.hasNext()) {
            ret = ret + Nachbarraeume.get(iterator.next().getKey()).getName() + "\t";
        }

        return ret;
    }


    public HashMap<String, Raum> getNachbarraeume() {
        return Nachbarraeume;
    }
}