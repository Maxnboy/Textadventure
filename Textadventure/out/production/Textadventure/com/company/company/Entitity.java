package com.company;

public abstract class Entitity {
    String name;
    String description;

    public Entitity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String toString() {
        return name + ":\t" + description;
    }

    protected String getName() {
        return name;
    }
}
