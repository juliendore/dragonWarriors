package com.dragonWarriors;

import com.dragonWarriors.personnages.*;

import java.util.Scanner;

public class Menu {

    public Warrior newGameW() {
        System.out.println("What is your name");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Warrior warrior = new Warrior(name);
        return warrior;
    }

    public Magician newGameM() {
        System.out.println("What is your name");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Magician magician = new Magician(name);
        return magician;
    }


}
