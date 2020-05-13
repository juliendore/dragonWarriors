package com.dragonWarriors.personnages;

public class Warrior {
    private String name;

    public Warrior(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hey guys my name is " + this.name + ". I'm a warrior.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
