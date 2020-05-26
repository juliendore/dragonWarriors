package com.dragonWarriors;

import com.dragonWarriors.bonus.Bonus;
import com.dragonWarriors.enemy.Enemy;

public class Case {

    private int id;

    public Case() {

    }

    public Case(int id) {
        this.id = id;
        switch (id) {
            case 2:
                Enemy enemy = new Enemy("Drago the cruel Dragon");
                System.out.println("Here's the case " + id + ". Watch out ! There's an " + enemy.getClass().getSimpleName() + " on that case : " + enemy.getName());
                System.out.println("===============");
                break;
            case 4:
                Bonus bonus = new Bonus();
                System.out.println("Here's the case " + id + ". There's a " + bonus.getClass().getSimpleName() + " on that case.");
                System.out.println("===============");
                break;
            default:
                System.out.println("Here's the case " + id + ". This is an empty case");
                System.out.println("===============");
        }
    }


}
