package com.dragonWarriors;

import com.dragonWarriors.characters.*;
import com.dragonWarriors.characters.Character;

//import com.dragonWarriors.Game.*;

import java.util.Scanner;

public class Menu {

    public void welcome() {
        Scanner input = new Scanner(System.in);
        System.out.println("===============");
        System.out.println("Dragon Warriors");
        System.out.println("An epic journey, a hero's quest");
        System.out.println("    start");
        System.out.println("    quit");
        System.out.println("===============");

        String userinput = input.nextLine();
        boolean isOkay = true;
        while (isOkay) {
            switch (userinput) {
                case "start":
                    this.newCharacter();
                    isOkay = false;
                    break;
                case "quit":
                    this.caseQuit();
                    break;
                default:
                    System.out.println("Incorrect entry.");
                    this.welcome();
            }
        }
    }

    private void newCharacter() {
        System.out.println("===============");
        System.out.println("Choose your character");
        System.out.println("    warrior");
        System.out.println("    wizard");
        System.out.println("===============");

        Scanner input = new Scanner(System.in);
        String userinput = input.nextLine();
        System.out.println("===============");
        System.out.println("What is your name ?");
        System.out.println("===============");

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        switch (userinput) {
            case "warrior":
                Warrior warrior = new Warrior(name);
                warrior.sayHello();
                next(warrior);
                break;
            case "wizard":
                Wizard wizard = new Wizard(name);
                wizard.sayHello();
                next(wizard);
                break;
            case "quit":
                this.caseQuit();
                break;
            default:
                System.out.println("===============");
                System.out.println("Incorrect entry.");
                System.out.println("===============");
                this.newCharacter();
        }
    }

    public void next(Character player) {
        System.out.println("===============");
        System.out.println("What do you want to do now ?");
        System.out.println("    infos");
        System.out.println("    rename");
        System.out.println("    play");
        System.out.println("===============");
        Scanner input = new Scanner(System.in);
        String userinput = input.nextLine();
        switch (userinput) {
            case "infos":
                System.out.println("  |  Name : " + player.getName());
                System.out.println("  |  Class : " + player.getClass().getSimpleName());
                System.out.println("  |  Hp : " + player.getHp());
                System.out.println("  |  Strength : " + player.getStrength());
                System.out.println("===============");
                this.next(player);
                break;
            case "rename":
                System.out.println("What is your new name ?");
                System.out.println("===============");
                input = new Scanner(System.in);
                userinput = input.nextLine();
                player.setName(userinput);
                this.next(player);
                break;
            case "play":
//                Game game = new Game();
//                game.play(1);
                Board board = new Board();
                board.play(player);
                break;
            case "quit":
                this.caseQuit();
                break;
            default:
                System.out.println("Incorrect entry.");
                this.next(player);
        }
    }

    public void caseQuit() {
        System.out.println("===============");
        System.out.println("See you soon !");
        System.out.println("===============");
        System.exit(0);
    }

}

