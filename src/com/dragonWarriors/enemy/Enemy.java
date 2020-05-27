package com.dragonWarriors.enemy;

import com.dragonWarriors.Case;

public class Enemy implements Case {
    private String name;
    private int hp;
    private int attack;

    public Enemy() {

    }

    public Enemy(String name) {
        this.name = name;
    }

    public Enemy(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public void doThis() {
        System.out.println("Voici l'attaque de l'ennemi");
    }
}
