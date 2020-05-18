package com.dragonWarriors.personnages;

public class Magician extends Personnage {

    private String name;
    private int hp;
    private int attack;

    public Magician(String name){
        super(name);
        this.hp = 3;
        this.attack = 8;
    }

    public void sayHello() {
        System.out.println("I am a mighty " + this.getClass().getSimpleName() + ", my name is " + this.getName() + ".");
    }

}
