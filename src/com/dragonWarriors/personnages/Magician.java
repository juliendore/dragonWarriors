package com.dragonWarriors.personnages;

public class Magician {
    private String name;

    public Magician(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Je suis un puissant " + this.getClass().getSimpleName() + ", mon nom est " + this.getName() + ".");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
