package com.dragonWarriors;

import com.dragonWarriors.characters.*;
import com.dragonWarriors.characters.Character;

import java.util.Scanner;

/**
 * La classe Menu permet d'afficher le menu d'accueil, d'instancier un nouveau personnage, de lancer une partie et de
 * quitter le programme.
 */
public class Menu {

    /**
     * Cette méthode permet de demander à l'utilisateur s'il souhaite commencer à jouer, auquel cas il pourra
     * saisir son nom (qui deviendra le nom du personnage plus tard) ou quitter le programme.
     */
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

    /**
     * Cette méthode à l'utilisateur de choisir s'il veut être un guerrier(warrior) ou un magicien(wizard). En fonction
     * de ce choix, une instance de la classe Warrior ou Wizard est créée.
     *
     * @param name le nom que le personnage va prendre, renseigné par l'utilisateur juste avant.
     */
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
                newGame(warrior);
                break;
            case "wizard":
                Wizard wizard = new Wizard(name);
                newGame(wizard);
                break;
            case "quit":
                this.caseQuit();
                break;
            default:
                System.out.println("Incorrect entry.");
                this.newCharacter(name);
        }
    }

    /**
     * Une fois le personnage créé, cette méthode permet à l'utilisateur d'obtenir un récaptitulatif des caractéristiques
     * de son personnage.
     * infos
     * |  Name : Toto
     * |  Class : Warrior
     * |  Hp : 5
     * |  Strength : 5
     * <p>
     * Eventuellement de changer le nom de son personnage s'il le souhaite. Enfin, l'utilisateur choisir de commencer
     * une nouvelle partie.
     *
     * @param player une instance de la classe Warrior ou Wizard (qui hérite de Character), le personnage créé précedemment.
     */
    private void newGame(Character player) {
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
                this.newGame(player);
                break;
            case "rename":
                System.out.println("What is your new name ?");
                System.out.println("===============");
                input = new Scanner(System.in);
                userinput = input.nextLine();
                player.setName(userinput);
                this.newGame(player);
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
                this.newGame(player);
        }
    }


    /**
     * Une méthode qui permet de quitter le programme après avoir affiché un message d'au revoir. Méthode statique qui
     * sera appelée à chaque fois que l'utilisateur peut et veut quitter la partie.
     */
    public static void caseQuit() {
        System.out.println("See you soon !");
        System.exit(0);
    }
}

