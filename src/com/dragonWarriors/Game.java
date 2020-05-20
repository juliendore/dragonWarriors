package com.dragonWarriors;

import java.util.Scanner;

public class Game {

    public int play(int pos) {
        Scanner input = new Scanner(System.in);
        System.out.println("===============");
        System.out.println("Position : " + pos + "/64");
        System.out.println("'roll' to roll the dice.");
        System.out.println("===============");
        String userinput = input.nextLine();
        switch (userinput) {
            case "debug":
                System.out.println("===============");
                System.out.println("debug mode, type wanted position.");
                input = new Scanner(System.in);
                pos = input.nextInt();
                break;
            case "roll":
                int dice1 = 0;
                try {
                    pos = this.caseRoll(pos, dice1);
                } catch (PersonnageHorsPlateauException e) {
                    pos = 50;
                }
                break;
            case "quit":
                this.caseQuit();
                break;
            default:
                System.out.println("Incorrect entry.");
                this.play(pos);
        }
        if (pos == 64) {
            System.out.println("Congratulation you've finished ! What do you want to do now ?");
            System.out.println("restart");
            System.out.println("quit");
            input = new Scanner(System.in);
            userinput = input.nextLine();
            switch (userinput) {
                case "restart":
                    pos = 1;
                    this.play(pos);
                    break;
                case "quit":
                    this.caseQuit();
                    break;
                default:
                    System.out.println("Incorrect entry.");
                    pos = 64;
            }

        }
        this.play(pos);

        return pos;
    }

    public int caseRoll(int pos, int dice1) throws PersonnageHorsPlateauException {
        dice1 = 1 + (int) (Math.random() * 6);
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
