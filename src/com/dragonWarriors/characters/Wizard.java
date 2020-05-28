package com.dragonWarriors.characters;

public class Wizard extends Character {

    public Wizard(String name) {
        super(name, 3, 8);
    }

    public void sayHello() {
        System.out.println("===============");
        System.out.println("I am a mighty " + this.getClass().getSimpleName() + ", my name is " + this.getName() + ".");

    }

}
