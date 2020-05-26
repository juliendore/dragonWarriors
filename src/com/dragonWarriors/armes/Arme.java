package com.dragonWarriors.armes;

public class Arme {

    private String name;
    private int force;

    public Arme() {
    }

    public Arme(String name) {
        this.name = name;
    }

    public Arme(String name, int force) {
        this.name = name;
        this.force = force;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }
}
