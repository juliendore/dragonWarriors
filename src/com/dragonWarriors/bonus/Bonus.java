package com.dragonWarriors.bonus;

import com.dragonWarriors.Case;

public class Bonus implements Case {

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
    public void doThis() {
        System.out.println("Voici le super bonus");
    }
}
