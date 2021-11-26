package com.company;

import java.util.ArrayList;

public interface Container {
    ArrayList<Ding> dinge = new ArrayList<>();

    default public void addDing(Ding ding) {
        dinge.add(ding);
    }

    default public void rmDing(Ding ding) {
        dinge.remove(ding);
    }
}
