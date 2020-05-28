package com.dragonWarriors.characters;

public abstract class Character {
    private String name;
    private int hp;
    private int strength;

    public Character() {
    }

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.strength = attack;
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

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", attack=" + strength +
                '}';
    }
}
