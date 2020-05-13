package com.dragonWarriors;

import com.dragonWarriors.personnages.*;

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
                System.out.println("A bientôt !");
                System.exit(0);
                break;
            default:
                System.out.println("Saisie incorrecte.");
                this.welcome();
        }
    }

    public void select() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choisis ton personnage");
        System.out.println("warrior");
        System.out.println("magician");
        String userinput = input.nextLine();
        System.out.println("Quel est ton nom ?");
        switch (userinput) {
            case "warrior":
                Warrior warrior = this.newWarrior();
                warrior.sayHello();
                System.out.println("Que veux tu faire à présent ?");
                System.out.println("infos");
                System.out.println("rename");
                System.out.println("play");
                input = new Scanner(System.in);
                userinput = input.nextLine();
                switch (userinput) {
                    case "infos":
                        System.out.println("Nom du personnage :" + warrior.getName());
                        System.out.println("Type du personnage :" + warrior.getClass().getSimpleName());
                        break;
                    case "rename":
                        System.out.println("Quel nom voulez vous donner ?");
                        input = new Scanner(System.in);
                        userinput = input.nextLine();
                        warrior.setName(userinput);
                        warrior.sayHello();
                        break;
                    case "play":
                        int pos = 1;
                        this.play(pos);
                    case "quit":
                        System.out.println("A bientôt !");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Saisie incorrecte.");
                        this.select();
                }
                break;
            case "magician":
                Magician magician = this.newMagician();
                magician.sayHello();
                System.out.println("Que veux tu faire à présent ?");
                System.out.println("infos");
                System.out.println("rename");
                System.out.println("play");
                input = new Scanner(System.in);
                userinput = input.nextLine();
                switch (userinput) {
                    case "infos":
                        System.out.println("Nom du personnage :" + magician.getName());
                        System.out.println("Type du personnage :" + magician.getClass().getSimpleName());
                        break;
                    case "rename":
                        System.out.println("Quel nom voulez vous donner ?");
                        input = new Scanner(System.in);
                        userinput = input.nextLine();
                        magician.setName(userinput);
                        magician.sayHello();
                        break;
                    case "play":
                        int pos = 1;
                        this.play(pos);
                    case "quit":
                        System.out.println("A bientôt !");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Saisie incorrecte.");
                        this.select();
                }
                break;
            case "quit":
                System.out.println("A bientôt !");
                System.exit(0);
                break;
            default:
                System.out.println("Saisie incorrecte.");
                this.select();
        }
    }

    public int play(int pos) {
        Scanner input = new Scanner(System.in);
        System.out.println("Position actuelle : " + pos + "/64");
        System.out.println("'roll' pour lancer le dé.");
        String userinput = input.nextLine();
        switch (userinput) {
            case "roll":
                int dice1 = 0;
                dice1 = 1 + (int) (Math.random() * 6);
                pos += dice1;
                System.out.println("Résultat du lancer de dé : " + dice1);
                if (pos >= 64) {
                    System.out.println("Bravo tu as fini que veux tu faire ?");
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
                            System.out.println("A bientôt !");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Saisie incorrecte.");
                            pos = 64;
                    }

                }
                this.play(pos);
                break;
            case "quit":
                System.out.println("A bientôt !");
                System.exit(0);

                break;
            default:
                System.out.println("Saisie incorrecte.");
                this.play(pos);
        }

        return pos;
    }

    public Warrior newWarrior() {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Warrior warrior = new Warrior(name);
        return warrior;
    }

    public Magician newMagician() {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Magician magician = new Magician(name);
        return magician;
    }
}
