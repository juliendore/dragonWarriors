package com.dragonWarriors.personnages;

public abstract class Character {

    private String name;
    private int hp;
    private int attack;

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return this.hp;
    }

    public int getAttack() {
        return this.attack;
    }

}
