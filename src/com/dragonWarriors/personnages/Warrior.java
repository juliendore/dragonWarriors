package com.dragonWarriors.personnages;

public class Warrior extends Personnage {

    private String name;
    private int hp;
    private int attack;

    public Warrior(String name) {
        super(name);
        this.hp = 5;
        this.attack = 5;
    }

    public void sayHello() {
        System.out.println("I am a strong " + this.getClass().getSimpleName() + ", my name is " + this.getName() + ".");
    }

    public int getHp() {
        return this.hp;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
