package com.dragonWarriors;

import java.util.Scanner;

public class Game {

    public int play(int pos) {
        Scanner input = new Scanner(System.in);
        System.out.println("Position : " + pos + "/64");
        System.out.println("'roll' to roll the dice.");
        String userinput = input.nextLine();
        switch (userinput) {
            case "roll":
                int dice1 = 0;
                dice1 = 1 + (int) (Math.random() * 6);
                pos += dice1;
                System.out.println("Dice roll : " + dice1);
                if (pos >= 64) {
                    System.out.println("Congratulation you've finished ! What do you want to do now ?");
                    System.out.println("restart");
                    System.out.println("quit");
                    input = new Scanner(System.in);
                    userinput = input.nextLine();
                    switch (userinput) {
                        case "restart":
                            pos = 0;
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
                break;
            case "quit":
                this.caseQuit();
                break;
            default:
                System.out.println("Incorrect entry.");
                this.play(pos);
        }

        return pos;
    }

    public void caseQuit() {
        System.out.println("See you soon !");
        System.exit(0);
    }
}
