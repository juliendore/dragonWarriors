package com.dragonWarriors;

import com.dragonWarriors.personnages.Magician;
import com.dragonWarriors.personnages.Warrior;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome, type 'start' to start or 'quit' to quit ");
        String userinput = input.nextLine();


        switch (userinput) {
            case "start":
                input = new Scanner(System.in);
                System.out.println("Do you want to be a warrior or a magician ? ");
                userinput = input.nextLine();
                switch (userinput) {
                    case "warrior":
                        Warrior warrior = menu.newGameW();
                        warrior.sayHello();
                        break;
                    case "magician":
                        Magician magician = menu.newGameM();
                        magician.sayHello();
                        break;
                }
                break;
            case "quit":
                System.out.println("Bye bye.");
                break;
            default:
                System.out.println("Je n'ai pas compris.");
        }


//        if (userinput.equals("start")) {
//            input = new Scanner(System.in);
//            System.out.println("Do you want to be a warrior or a magician ? ");
//            userinput = input.nextLine();
//            if (userinput.equals("warrior")) {
//                Warrior player = menu.newGameW();
//                player.sayHello();
//            }
//            if (userinput.equals("magician")) {
//                Magician player = menu.newGameM();
//                player.sayHello();
//            }
//
//        }
//
//
//        if (userinput.equals("quit")) {
//            System.out.println("Bye bye");
//
//        }


    }
}
