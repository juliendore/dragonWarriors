package com.dragonWarriors.potions;

import com.dragonWarriors.EmptyCase;
import com.dragonWarriors.Game;
import com.dragonWarriors.interfaces.Case;
import com.dragonWarriors.interfaces.HpInteraction;
import com.dragonWarriors.characters.Character;

import java.util.ArrayList;


public abstract class Potion implements Case, HpInteraction {

    private String name;
    private int hp;

    public Potion() {

    }

    public Potion(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doThis(Character player, ArrayList board, Game game) {
        System.out.println("You find a " + this.name + " on the floor.");
        this.hpInteraction(player);
        board.set(board.indexOf(this), new EmptyCase());
    }

    @Override
    public void hpInteraction(Character player) {
        System.out.println("You can now benefit from + " + this.hp + " hp.");
        player.setHp(player.getHp() + this.hp);
        System.out.println("Your new stats :");
        System.out.println("  |  Hp : " + player.getHp());
        System.out.println("  |  Strength : " + player.getStrength());
    }
}
