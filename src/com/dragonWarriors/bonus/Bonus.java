package com.dragonWarriors.bonus;

import com.dragonWarriors.Case;
import com.dragonWarriors.HpInteraction;
import com.dragonWarriors.personnages.Character;


public class Bonus implements Case, HpInteraction {

    private String name;

    public Bonus() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doThis(Character player) {
        System.out.println("Great bonus !");
        this.hpInteraction(player);
    }

    @Override
    public void hpInteraction(Character player) {
        System.out.println("Yay you can now benefit from + 8 hp.");
        player.setHp(player.getHp() + 8);
    }
}
