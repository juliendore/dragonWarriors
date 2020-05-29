package com.dragonWarriors.enemies;

import com.dragonWarriors.EmptyCase;
import com.dragonWarriors.Game;
import com.dragonWarriors.Menu;
import com.dragonWarriors.interfaces.Fight;
import com.dragonWarriors.interfaces.HpInteraction;
import com.dragonWarriors.interfaces.Case;
import com.dragonWarriors.characters.Character;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Enemy implements Case, HpInteraction, Fight {
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
    public void doThis(Character player, ArrayList board, Game game) {
        System.out.println("I am the " + this.getName() + ".");
        fight(player, board, game);

    }

    @Override
    public void fight(Character player, ArrayList board, Game game) {
        System.out.println("Enemy's stats :");
        System.out.println("  |  Hp : " + this.getHp());
        System.out.println("  |  Strength : " + this.getStrength());
        System.out.println("===============");
        System.out.println("What do you want to do");
        System.out.println("    fight");
        System.out.println("    flee");
        System.out.println("===============");
        Scanner input = new Scanner(System.in);
        String userinput = input.nextLine();
        switch (userinput) {
            case "fight":
                int damage = (int) (player.getStrength() * 0.6);
                System.out.println("Take this ! You make " + damage + " hp of damage to " + this.getName() + ".");
                this.setHp(this.getHp() - damage);
                if (this.getHp() > 0) {
                    this.hpInteraction(player);
                    this.fight(player, board, game);
                } else if (this.getHp() <= 0) {
                    System.out.println("You've killed your enemy.");
                    board.set(board.indexOf(this), new EmptyCase());
                }
                break;
            case "flee":
                if (game.getPos() > 1) {
                    System.out.println("You choose to run away ! You have to go back.");
                    game.setPos(game.getPos() - 1);
                    game.play(player);
                } else {
                    System.out.println("You can't run away ! You have to face your enemy");
                    this.fight(player, board, game);
                }
                break;
            case "quit":
                Menu.caseQuit();
                break;
            default:
                System.out.println("Incorrect entry.");
                this.fight(player, board, game);
        }

    }

    @Override
    public void hpInteraction(Character player) {
        int damage = (int) (this.getStrength() * 0.4);
        player.setHp(player.getHp() - damage);
        System.out.println("Here is the " + this.getName() + "'s attack. You take " + damage + " hp of damage.");
        if (player.getHp() <= 0) {
            System.out.println("                     _           _");
            System.out.println("                   _/ \\ _______ / \\_ ");
            System.out.println("                  /  __/__   __\\__  \\");
            System.out.println("                   \\_/____ \\ / ____\\_/");
            System.out.println("                    //    \\___/    \\\\");
            System.out.println("                   | |   o _ _ o   | |");
            System.out.println("                    \\_\\___/ V \\___/_/");
            System.out.println("                    < `    | |    ' >");
            System.out.println("                     \\__.  \\^/  .__/");
            System.out.println("                       >         <");
            System.out.println("                       [_I_I_I_I_]");
            System.out.println("                      /  /   \\  \\");
            System.out.println("                    _/  /     \\  \\_");
            System.out.println("                   /   <       >   \\");
            System.out.println("                   \\_.  |     |  ._/");
            System.out.println("                     \\_/       \\_/");

            System.out.println("  ________                                                  ");
            System.out.println(" /  _____/_____    _____   ____     _______  __ ___________ ");
            System.out.println("/   \\  ___\\__  \\  /     \\_/ __ \\   /  _ \\  \\/ // __ \\_  __ \\");
            System.out.println("\\    \\_\\  \\/ __ \\|  Y Y  \\  ___/  (  <_> )   /\\  ___/|  | \\/");
            System.out.println(" \\______  (____  /__|_|  /\\___  >  \\____/ \\_/  \\___  >__|   ");
            System.out.println("        \\/     \\/      \\/     \\/                   \\/       ");



            System.exit(0);
        }
        System.out.println("Your stats :");
        System.out.println("  |  Hp : " + player.getHp());
        System.out.println("  |  Strength : " + player.getStrength());
    }
}
