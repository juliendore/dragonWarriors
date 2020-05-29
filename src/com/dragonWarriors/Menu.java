package com.dragonWarriors;

import com.dragonWarriors.characters.*;
import com.dragonWarriors.characters.Character;

//import com.dragonWarriors.Game.*;

import java.util.Scanner;

public class Menu {

    public void welcome() {
        Scanner input = new Scanner(System.in);

        System.out.println("               ____                                  _       __                _              \n" +
                "              / __ \\_________ _____ _____  ____     | |     / ____ ___________(_____  _____   \n" +
                "             / / / / ___/ __ `/ __ `/ __ \\/ __ \\    | | /| / / __ `/ ___/ ___/ / __ \\/ ___/   \n" +
                "            / /_/ / /  / /_/ / /_/ / /_/ / / / /    | |/ |/ / /_/ / /  / /  / / /_/ / /       \n" +
                "   ______  /_____/_/   \\__,_/\\__, /\\____/_/ /_/     |__/|__/\\__,_/_/  /_/  /_/\\____/_/        \n" +
                "  / ________ _____ ___  ____/____/_______   ____  __  ______ ___  ___  _____(_____ ___  _____ \n" +
                " / /   / __ `/ __ `__ \\/ __ \\/ / / / ___/  / __ \\/ / / / __ `__ \\/ _ \\/ ___/ / __ `/ / / / _ \\\n" +
                "/ /___/ /_/ / / / / / / /_/ / /_/ (__  )  / / / / /_/ / / / / / /  __/ /  / / /_/ / /_/ /  __/\n" +
                "\\____/\\__,_/_/ /_/ /_/ .___/\\__,_/____/  /_/ /_/\\__,_/_/ /_/_\\_/\\___/_/  /_/\\__, /\\__,_/\\___/ \n" +
                "                    /_/     ____  _________    (____  _____/ /_               /_/             \n" +
                "                           / __ \\/ ___/ __ \\  / / _ \\/ ___/ __/                               \n" +
                "                          / /_/ / /  / /_/ / / /  __/ /__/ /_                                 \n" +
                "                         / .___/_/   \\______/ /\\___/\\___/\\__/                                 \n" +
                "                        /_/              /___/                                                ");

//        System.out.println("    .___                                      ");
//        System.out.println("  __| _/___________     ____   ____   ____    ");
//        System.out.println(" / __ |\\_  __ \\__  \\   / ___\\ /  _ \\ /    \\   ");
//        System.out.println("/ /_/ | |  | \\// __ \\_/ /_/  >  <_> )   |  \\  ");
//        System.out.println("\\____ | |__|  (____  /\\___  / \\____/|___|  /  ");
//        System.out.println("     \\/            \\//_____/             \\/   ");
//        System.out.println("                             .__              ");
//        System.out.println("__  _  _______ ______________|__| ___________ ");
//        System.out.println("\\ \\/ \\/ /\\__  \\\\_  __ \\_  __ \\  |/  _ \\_  __ \\");
//        System.out.println(" \\     /  / __ \\|  | \\/|  | \\/  (  <_> )  | \\/");
//        System.out.println("  \\/\\_/  (____  /__|   |__|  |__|\\____/|__|   ");
//        System.out.println("              \\/                              ");
//        System.out.println(" ");
//        System.out.println(" ");
//        System.out.println(" ");
//
//        System.out.println("   ______                                                                    _                ");
//        System.out.println("  / ________ _____ ___  ____  __  _______   ____  __  ______ ___  ___  _____(_____ ___  _____ ");
//        System.out.println(" / /   / __ `/ __ `__ \\/ __ \\/ / / / ___/  / __ \\/ / / / __ `__ \\/ _ \\/ ___/ / __ `/ / / / _ \\");
//        System.out.println("/ /___/ /_/ / / / / / / /_/ / /_/ (__  )  / / / / /_/ / / / / / /  __/ /  / / /_/ / /_/ /  __/");
//        System.out.println("\\____/\\__,_/_/ /_/ /_/ .___/\\__,_/____/  /_/ /_/\\__,_/_/ /_/ /_/\\___/_/  /_/\\__, /\\__,_/\\___/ ");
//        System.out.println("                    /_/                                                       /_/             ");
        System.out.println("An epic journey, a hero's quest");
        System.out.println("    start");
        System.out.println("    quit");
        System.out.println("===============");

        String userinput = input.nextLine();
        boolean isOkay = true;
        while (isOkay) {
            switch (userinput) {
                case "start":
                    System.out.println("===============");
                    System.out.println("What is your name ?");
                    System.out.println("===============");
                    Scanner sc = new Scanner(System.in);
                    String name = sc.nextLine();
                    this.newCharacter(name);
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

    private void newCharacter(String name) {
        System.out.println("===============");
        System.out.println("Choose your character");
        System.out.println("    warrior");
        System.out.println("    wizard");
        System.out.println("===============");

        Scanner input = new Scanner(System.in);
        String userinput = input.nextLine();

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
                System.out.println("Incorrect entry.");
                this.newCharacter(name);
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
                Game game = new Game();
                game.play(player);
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

