package com.dragonWarriors.personnages;

public class Magician {
    private String name;

    public Magician(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hey guys my name is " + this.name + ". I'm a magician.");
    }
}
