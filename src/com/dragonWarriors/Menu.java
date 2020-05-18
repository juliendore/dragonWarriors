package com.dragonWarriors;

import com.dragonWarriors.personnages.*;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Menu {

    public void welcome() {
        Scanner input = new Scanner(System.in);
        System.out.println("Dragon Warriors");
        System.out.println("start");
        System.out.println("quit");
        String userinput = input.nextLine();
        switch (userinput) {
            case "start":
                this.select();
                break;
            case "quit":
                this.caseQuit();
                break;
            default:
                System.out.println(".");
                this.welcome();
        }
    }

    public void select() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose your character");
        System.out.println("warrior");
        System.out.println("magician");
        String userinput = input.nextLine();
        System.out.println("What is your name ?");
        switch (userinput) {
            case "warrior":
                Warrior warrior = newWarrior();
                warrior.sayHello();
                next(warrior);
                break;
            case "magician":
                Magician magician = this.newMagician();
                magician.sayHello();
//                next(magician);
                break;
            case "quit":
                this.caseQuit();
                break;
            default:
                System.out.println("Incorrect entry.");
                this.select();
        }
    }


    public void next(Warrior player) {
        System.out.println("What do you want to do now ?");
        System.out.println("infos");
        System.out.println("rename");
        System.out.println("play");
        Scanner input = new Scanner(System.in);
        String userinput = input.nextLine();
        switch (userinput) {
            case "infos":
                System.out.println("Name : " + player.getName());
                System.out.println("Type : " + player.getClass().getSimpleName());
                System.out.println("Hp : " + player.getHp());
                System.out.println("Attack : " + player.getAttack());
                this.next(player);
                break;
            case "rename":
                System.out.println("What is your new name ?");
                input = new Scanner(System.in);
                userinput = input.nextLine();
                player.setName(userinput);
                this.next(player);
                break;
            case "play":
                int pos = 1;
                this.play(pos);
            case "quit":
                this.caseQuit();
                break;
            default:
                System.out.println("Incorrect entry.");
                this.next(player);
        }
    }

    public void caseQuit() {
        System.out.println("See you soon !");
        System.exit(0);
    }

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

    public Warrior newWarrior() {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        return new Warrior(name);
    }

    public Magician newMagician() {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Magician magician = new Magician(name);
        return magician;
    }
}
