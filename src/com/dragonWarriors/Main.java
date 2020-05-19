package com.dragonWarriors;

public class Main {

    public static void main(String[] args) throws PersonnageHorsPlateauException {
        Menu menu = new Menu();
        try {
            menu.welcome();
        } catch (PersonnageHorsPlateauException e) {
            Game game = new Game();
            game.play(50);
        }

    }
}
