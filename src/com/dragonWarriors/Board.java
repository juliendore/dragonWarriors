package com.dragonWarriors;

import com.dragonWarriors.bonus.Bonus;
import com.dragonWarriors.empty.Empty;
import com.dragonWarriors.enemy.Enemy;
import com.dragonWarriors.personnages.Character;
import com.dragonWarriors.weapons.Weapon;
import java.util.ArrayList;
import java.util.Scanner;



public class Board {

    private int pos;

    private ArrayList<Case> board = new ArrayList();

    public Board() {
        this.pos = 1;
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 1:
                    this.board.add(new Enemy("Drago the cruel Dragon"));
                    break;
                case 2:
                    this.board.add(new Weapon("Dragon slayer sword", 10));
                    break;
                case 3:
                    this.board.add(new Bonus());
                    break;
                default:
                    this.board.add(new Empty());
            }
        }
    }


    public void play(Character player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Current position > " + this.pos + " :  " + this.board.get(this.pos - 1).getClass().getSimpleName() + " case");
        this.board.get(this.pos - 1).doThis(player);
        System.out.println("Your stats :");
        System.out.println("  |  Hp : " + player.getHp());
        System.out.println("  |  Strength : " + player.getStrength());
        System.out.println("'roll' to roll the dice.");
        System.out.println("===============");
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
                    this.pos = 58;
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
//        dice1 = 1 + (int) (Math.random() * 6);
        dice1 = 1;
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


