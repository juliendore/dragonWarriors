package com.dragonWarriors.enemies;

import com.dragonWarriors.interfaces.HpInteraction;
import com.dragonWarriors.interfaces.Case;
import com.dragonWarriors.characters.Character;

public abstract class Enemy implements Case, HpInteraction {
    private String name;
    private int hp;
    private int strength;

    public Enemy() {

    }

    public Enemy(String name) {
        this.name = name;
    }

    public Enemy(String name, int hp, int strength) {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
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
        System.out.println("Here's " + this.getName() + "'s attack");
        hpInteraction(player);
    }

    @Override
    public void hpInteraction(Character player) {
        int damage = (int) (this.getStrength() * 0.4);
        System.out.println("Oh no you've just lost " + damage + " hp !");
        player.setHp(player.getHp() - damage);
    }
}
