package com.dragonWarriors.weapons;

import com.dragonWarriors.characters.Warrior;
import com.dragonWarriors.characters.Wizard;
import com.dragonWarriors.interfaces.Case;
import com.dragonWarriors.interfaces.StrengthInteraction;
import com.dragonWarriors.characters.Character;

public abstract class Weapon implements Case, StrengthInteraction {

    private String name;
    private int strength;
    private int speed;

    public Weapon() {
    }

    public Weapon(String name) {
        this.name = name;
    }

    public Weapon(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public Weapon(String name, int strength, int speed) {
        this.name = name;
        this.strength = strength;
        this.speed = speed;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void doThis(Character player) {
        if (player instanceof Warrior) {
            System.out.println("There is an " + this.getName() + ". You pick it up and perform a few swings with it");
            this.strengthInteraction(player);
        } else {
            System.out.println("You find an " + this.getName() + ", but you have no idea of how to use it.");
        }
    }

    @Override
    public void strengthInteraction(Character player) {
        System.out.println("Yay you can now benefit from + " + this.getStrength() + " strength.");
        player.setStrength(player.getStrength() + this.getStrength());
    }
}
