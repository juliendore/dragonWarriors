package com.dragonWarriors.personnages;

public class Magician extends Character {

    public Magician(String name) {
        super(name, 3, 8);
    }

    public void sayHello() {
        System.out.println("===============");
        System.out.println("I am a mighty " + this.getClass().getSimpleName() + ", my name is " + this.getName() + ".");
        System.out.println("===============");

    }

}
