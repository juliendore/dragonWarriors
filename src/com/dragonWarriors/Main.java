package com.dragonWarriors;

/**
 * La classe Main est le point d'entrée du programme.
 */
public class Main {

    /**
     * Cette méthode main() permet d'instancier ma classe Menu et d'exécuter la méthode welcome() pour afficher le
     * menu principal.
     *
     * @param args
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.welcome();
    }

}
