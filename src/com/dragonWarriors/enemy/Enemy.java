package com.dragonWarriors.enemy;

import com.dragonWarriors.HpInteraction;
import com.dragonWarriors.Case;
import com.dragonWarriors.personnages.Character;

public class Enemy implements Case, HpInteraction {
    private String name;
    private int hp;
    private int strength;

    public Enemy() {

    }

    public Enemy(String name) {
        this.name = name;
    }

    public Enemy(String name, int hp, int attack) {
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
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void doThis(Character player) {
        System.out.println("I am " + this.getName() + ".");
        System.out.println("Here's the enemy's attack");
        hpInteraction(player);
    }

    @Override
    public void hpInteraction(Character player) {
        System.out.println("Oh no you've just lost 1 hp !");
        player.setHp(player.getHp() - 1);
    }
}
