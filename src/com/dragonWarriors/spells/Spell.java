package com.dragonWarriors.spells;

import com.dragonWarriors.EmptyCase;
import com.dragonWarriors.Game;
import com.dragonWarriors.characters.Wizard;
import com.dragonWarriors.interfaces.Case;
import com.dragonWarriors.interfaces.StrengthInteraction;
import com.dragonWarriors.characters.Character;

import java.util.ArrayList;

public abstract class Spell implements Case, StrengthInteraction {

    private String name;
    private int strength;
    private int speed;

    public Spell() {

    }

    public Spell(String name) {
        this.name = name;
    }

    public Spell(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public Spell(String name, int strength, int speed) {
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
    public void doThis(Character player, ArrayList board, Game game){
        if (player instanceof Wizard) {
            System.out.println("You learn to cast a " + this.getName() + " spell.");
            this.strengthInteraction(player);
            board.set(board.indexOf(this), new EmptyCase());
        } else {
            System.out.println("You find a " + this.getName() + " spell, but you have no idea of how to use it.");
        }
    }

    @Override
    public void strengthInteraction(Character player) {
        System.out.println("Yay you can now benefit from + " + this.getStrength() + " strength.");
        player.setStrength(player.getStrength() + this.getStrength());
        System.out.println("Your new stats :");
        System.out.println("  |  Hp : " + player.getHp());
        System.out.println("  |  Strength : " + player.getStrength());
    }
}
