package com.dragonWarriors;

import com.dragonWarriors.characters.Warrior;
import com.dragonWarriors.enemies.Gobelin;
import com.dragonWarriors.enemies.Witch;
import com.dragonWarriors.potions.BigPotion;
import com.dragonWarriors.enemies.Dragon;
import com.dragonWarriors.interfaces.Case;
import com.dragonWarriors.characters.Character;
import com.dragonWarriors.potions.StandardPotion;
import com.dragonWarriors.spells.Fire;
import com.dragonWarriors.spells.Lightning;
import com.dragonWarriors.weapons.Mace;
import com.dragonWarriors.weapons.Sword;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;


public class Game {



    private int pos;

    private ArrayList<Case> board = new ArrayList();

    public Game() {
        this.pos = 1;
        int maxcases = 64;
        int maxdragon = 4;
        int maxgobelin = 10;
        int maxwitch = 10;
        int maxmace = 5;
        int maxsword = 4;
        int maxlighting = 5;
        int maxfire = 2;
        int maxstandardpotion = 6;
        int maxbigpotion = 2;
        int emptycases = maxcases - maxdragon - maxgobelin - maxwitch - maxmace - maxsword - maxlighting - maxfire - maxstandardpotion - maxbigpotion;

        for (int i = 0; i < maxdragon; i++) {
            this.board.add(new Dragon());
        }
        for (int i = 0; i < maxgobelin; i++) {
            this.board.add(new Gobelin());
        }
        for (int i = 0; i < maxwitch; i++) {
            this.board.add(new Witch());
        }
        for (int i = 0; i < maxmace; i++) {
            this.board.add(new Mace("Awesome mace"));
        }
        for (int i = 0; i < maxsword; i++) {
            this.board.add(new Sword("Awesome sword"));
        }
        for (int i = 0; i < maxlighting; i++) {
            this.board.add(new Lightning());
        }
        for (int i = 0; i < maxfire; i++) {
            this.board.add(new Fire());
        }
        for (int i = 0; i < maxstandardpotion; i++) {
            this.board.add(new StandardPotion());
        }
        for (int i = 0; i < maxbigpotion; i++) {
            this.board.add(new BigPotion());
        }
        for (int i = 0; i < emptycases; i++) {
            this.board.add(new EmptyCase());
        }

        Collections.shuffle(board);

//        System.out.println("Nombre de cases : " + this.board.size());
//        for (Case c : board
//        ) {
//            System.out.println(c);
//        }

    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }


    public void play(Character player) {
        System.out.println("Current position > " + this.pos + "/64");
        System.out.println("Your stats :");
        System.out.println("  |  Hp : " + player.getHp());
        System.out.println("  |  Strength : " + player.getStrength());
        this.board.get(this.pos - 1).doThis(player, this.board, this);

//        for (Case c : board
//        ) {
//            System.out.println(c);
//        }

        System.out.println("'roll' to roll the dice.");
        System.out.println("===============");
        Scanner input = new Scanner(System.in);
        String userinput = input.nextLine();
        switch (userinput) {
            case "debug":
                System.out.println("===============");
                System.out.println("debug mode, type wanted position.");
                input = new Scanner(System.in);
                this.pos = input.nextInt();
                break;
            case "roll":
                int dice1 = 0;
                try {
                    this.pos = this.caseRoll(this.pos, dice1);
                } catch (PersonnageHorsPlateauException e) {
                    this.pos = 50;
                }
                break;
            case "quit":
                this.caseQuit();
                break;
            default:
                System.out.println("Incorrect entry.");
                this.play(player);
        }
        if (this.pos == 64) {
            System.out.println("Congratulation you've finished ! What do you want to do now ?");
            System.out.println("restart");
            System.out.println("quit");
            input = new Scanner(System.in);
            userinput = input.nextLine();
            switch (userinput) {
                case "restart":
                    this.pos = 1;
                    this.play(player);
                    break;
                case "quit":
                    this.caseQuit();
                    break;
                default:
                    System.out.println("Incorrect entry.");
                    this.pos = 64;
            }

        }
        this.play(player);

    }

    public int caseRoll(int pos, int dice1) throws PersonnageHorsPlateauException {
        dice1 = 1 + (int) (Math.random() * 6);
//        dice1 = 1;
        System.out.println("Dice roll : " + dice1);
        if (pos + dice1 > 64) {
            throw new PersonnageHorsPlateauException();
        }

        for (int i = 0; i < dice1; i++) {
            pos++;
        }

        return pos;
    }

    public void caseQuit() {
        System.out.println("See you soon !");
        System.exit(0);
    }

}


