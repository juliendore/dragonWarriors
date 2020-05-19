package com.dragonWarriors;

import com.dragonWarriors.personnages.*;
import com.dragonWarriors.personnages.Character;

import com.dragonWarriors.Game.*;

import java.util.Scanner;

public class Menu {

    public void welcome() throws PersonnageHorsPlateauException {
        Scanner input = new Scanner(System.in);
        System.out.println("===============");
        System.out.println("Dragon Warriors");
        System.out.println("An epic journey, a hero's quest");
        System.out.println("    start");
        System.out.println("    quit");
        System.out.println("===============");

        String userinput = input.nextLine();
        switch (userinput) {
            case "start":
                this.newCharacter();
                break;
            case "quit":
                this.caseQuit();
                break;
            default:
                System.out.println("Incorrect entry.");
                this.welcome();
        }
    }

    public void newCharacter() throws PersonnageHorsPlateauException {
        System.out.println("===============");
        System.out.println("Choose your character");
        System.out.println("    warrior");
        System.out.println("    magician");
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
            case "magician":
                Magician magician = new Magician(name);
                magician.sayHello();
                next(magician);
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

    public void next(Character player) throws PersonnageHorsPlateauException {
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
                System.out.println("===============");
                System.out.println("  |  Name : " + player.getName());
                System.out.println("  |  Type : " + player.getClass().getSimpleName());
                System.out.println("  |  Hp : " + player.getHp());
                System.out.println("  |  Attack : " + player.getAttack());
                System.out.println("===============");

//                System.out.println("recap : " + player.toString());
                this.next(player);
                break;
            case "rename":
                System.out.println("===============");
                System.out.println("What is your new name ?");
                System.out.println("===============");

                input = new Scanner(System.in);
                userinput = input.nextLine();
                player.setName(userinput);
                this.next(player);
                break;
            case "play":
                int pos = 1;
                Game game = new Game();
                try {
                    game.play(pos);
                } catch (PersonnageHorsPlateauException e) {
                    pos = 50;
                    game.play(pos);
                }
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
        System.exit(0);
        System.out.println("===============");
    }

}

