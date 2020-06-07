package com.dragonWarriors;

import com.dragonWarriors.characters.*;
import com.dragonWarriors.characters.Character;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * La classe Menu permet d'afficher le menu d'accueil, d'instancier un nouveau personnage, de lancer une partie et de
 * quitter le programme.
 */
public class Menu {

    private Connect connect;

    private ArrayList<String> presethero;

    public Menu() {
        this.connect = new Connect();
    }

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
        String userinput = input.nextLine().trim().toLowerCase();
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
        System.out.println("Create your own character");
        System.out.println("    warrior");
        System.out.println("    wizard");
        System.out.println("Or discover our presets heroes");
        System.out.println("    see 'all'");
        System.out.println("    'search' by id");
        System.out.println("===============");
        Scanner input = new Scanner(System.in);
        String userinput = input.nextLine().trim().toLowerCase();
        switch (userinput) {
            case "warrior":
                System.out.println("How many hp you have ?");
                Scanner hpscannerWa = new Scanner(System.in);
                int hpWa = hpscannerWa.nextInt();
                System.out.println("How strong are you ?");
                Scanner strengthscanner = new Scanner(System.in);
                int strengthWa = strengthscanner.nextInt();
                Warrior warrior = new Warrior(name, hpWa, strengthWa);
                newGame(warrior);
                break;
            case "wizard":
                System.out.println("How many hp you have ?");
                Scanner hpscannerWi = new Scanner(System.in);
                int hpWi = hpscannerWi.nextInt();
                System.out.println("How strong are you ?");
                Scanner strengthscannerWi = new Scanner(System.in);
                int strengthWi = strengthscannerWi.nextInt();
                Wizard wizard = new Wizard(name, hpWi, strengthWi);
                newGame(wizard);
                break;
            case "all":
                try {
                    this.connect.getHeroes();
                } catch (SQLException eHeroes) {
                    System.out.println(eHeroes);
                }
                this.newCharacter(name);
                break;
            case "search":
                System.out.println("What is the id of the hero you want to see ?");
                Scanner specifichero = new Scanner(System.in);
                int id = specifichero.nextInt();
                this.presethero = this.connect.getHero(id);
                System.out.println("  |  Name : " + this.presethero.get(2));
                System.out.println("  |  Class : " + this.presethero.get(1));
                System.out.println("  |  Hp : " + this.presethero.get(3));
                System.out.println("  |  Strength : " + this.presethero.get(4));
                System.out.println("What do you want to do with this hero");
                System.out.println("    play");
                System.out.println("    rename");
                System.out.println("    delete");
                Scanner startthisheroScanner = new Scanner(System.in);
                String startthisheroString = startthisheroScanner.nextLine().trim().toLowerCase();
                switch (startthisheroString) {
                    case "play":
                        System.out.println(this.presethero.get(0));
                        if (this.presethero.get(1).equals("Warrior")) {
                            Warrior preset = new Warrior(this.presethero.get(2), Integer.parseInt(this.presethero.get(3)), Integer.parseInt(this.presethero.get(4)));
                            newGame(preset);
                        }
                        if (this.presethero.get(1).equals("Wizard")) {
                            Wizard preset = new Wizard(this.presethero.get(2), Integer.parseInt(this.presethero.get(3)), Integer.parseInt(this.presethero.get(4)));
                            newGame(preset);
                        }
                        break;
                    case "rename":
                        Scanner newnamescanner = new Scanner(System.in);
                        String newname = newnamescanner.nextLine();
                        try {
                            this.connect.updateHero(Integer.parseInt(this.presethero.get(0)), newname);
                            System.out.println("Hero's new name is now " + newname + ".");
                        } catch (SQLException eRename) {
                            System.out.println(eRename);
                        }
                        this.newCharacter(name);
                        break;
                    case "delete":
                        System.out.println("Are you sure you want to delete " + this.presethero.get(2) + " ?");
                        Scanner confirmscanner = new Scanner(System.in);
                        String confirm = confirmscanner.nextLine().trim().toLowerCase();
                        switch (confirm) {
                            case "yes":
                                try {
                                    this.connect.deleteHero(Integer.parseInt(this.presethero.get(0)));
                                    System.out.println("You have deleted " + this.presethero.get(2) + ".");
                                } catch (SQLException eDelete) {
                                    System.out.println(eDelete);
                                }
                                this.newCharacter(name);
                                break;
                            case "no":
                                this.newCharacter(name);
                                break;
                        }
                        break;
                    case "default":
                        System.out.println("Incorrect entry");
                        this.newCharacter(name);
                        break;
                }
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
        System.out.println("    'add' your character to preset");
        System.out.println("===============");
        Scanner input = new Scanner(System.in);
        String userinput = input.nextLine().trim().toLowerCase();
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
            case "add":
                try {
                    this.connect.createHero(player.getName(), player.getClass().getSimpleName(), player.getHp(), player.getStrength());
                } catch (SQLException eAdd) {
                    System.out.println(eAdd);
                }
                this.newGame(player);
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

