package com.dragonWarriors.personnages;

public class Warrior {
    private String name;

    public Warrior(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Je suis un redoutable " + this.getClass().getSimpleName() + ", mon nom est " + this.getName() + ".");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
