package com.dragonWarriors;

import com.dragonWarriors.enemies.Gobelin;
import com.dragonWarriors.enemies.Witch;
import com.dragonWarriors.potions.BigPotion;
import com.dragonWarriors.potions.Potion;
import com.dragonWarriors.enemies.Dragon;
import com.dragonWarriors.interfaces.Case;
import com.dragonWarriors.characters.Character;
import com.dragonWarriors.potions.StandardPotion;
import com.dragonWarriors.spells.Fire;
import com.dragonWarriors.spells.Lightning;
import com.dragonWarriors.weapons.Mace;
import com.dragonWarriors.weapons.Sword;

import java.util.ArrayList;
import java.util.Scanner;


public class Board {

    private int pos;

    private ArrayList<Case> board = new ArrayList();

    public Board() {
        this.pos = 1;
        for (int i = 0; i < 64; i++) {
            switch (i) {
                // Instances of the enemies on the board
                case 45:
                case 52:
                case 56:
                case 62:
                    this.board.add(new Dragon());
                    break;
                case 10:
                case 20:
                case 25:
                case 32:
                case 35:
                case 36:
                case 37:
                case 40:
                case 44:
                case 47:
                    this.board.add(new Witch());
                    break;
                case 3:
                case 6:
                case 9:
                case 12:
                case 15:
                case 18:
                case 21:
                case 24:
                case 27:
                case 30:
                    this.board.add(new Gobelin());
                    break;


                // Instances of the loot on the board
                //weapons
                case 2:
                case 11:
                case 5:
                case 22:
                case 38:
                    this.board.add(new Mace("Awesome mace"));
                    break;
                case 19:
                case 26:
                case 42:
                case 53:
                    this.board.add(new Sword("Awesome sword"));
                    break;
                //spells
                case 1:
                case 4:
                case 8:
                case 17:
                case 23:
                    this.board.add(new Lightning());
                    break;
                case 48:
                case 49:
                    this.board.add(new Fire());
                    break;
                //potions
                case 7:
                case 13:
                case 31:
                case 33:
                case 39:
                case 43:
                    this.board.add(new StandardPotion());
                    break;
                case 28:
                case 41:
                    this.board.add(new BigPotion());
                    break;


                //empty cases
                default:
                    this.board.add(new EmptyCase());
            }
        }
        System.out.println("Nombre de cases : "+this.board.size());
    }


    public void play(Character player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Current position > " + this.pos + "/64");
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


