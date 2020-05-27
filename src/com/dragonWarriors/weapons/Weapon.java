package com.dragonWarriors.weapons;

import com.dragonWarriors.Case;
import com.dragonWarriors.StrengthInteraction;
import com.dragonWarriors.personnages.Character;

public class Weapon implements Case, StrengthInteraction {

    private String name;
    private int strength;

    public Weapon() {
    }

    public Weapon(String name) {
        this.name = name;
    }

    public Weapon(String name, int force) {
        this.name = name;
        this.strength = force;
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
        System.out.println("There is a " + this.getName() + ".");
        System.out.println("You pick up the weapon");
        this.strengthInteraction(player);
    }

    @Override
    public void strengthInteraction(Character player) {
        System.out.println("Yay you can now benefit from + " + this.getStrength() + " strength.");
        player.setStrength(player.getStrength() + this.getStrength());
    }
}
