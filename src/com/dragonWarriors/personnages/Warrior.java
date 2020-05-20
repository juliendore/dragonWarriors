package com.dragonWarriors.personnages;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 5, 5);
    }

    public void sayHello() {
        System.out.println("===============");
        System.out.println("I am a strong " + this.getClass().getSimpleName() + ", my name is " + this.getName() + ".");
        System.out.println("===============");
    }

}
