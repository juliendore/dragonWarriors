package com.dragonWarriors;

import com.dragonWarriors.characters.Warrior;
import java.lang.Character;
import java.sql.*;
import java.util.ArrayList;
import com.dragonWarriors.enemies.*;


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

        //Restrictions dans la déclaration de ma collection.
//        ArrayList<? extends Enemy> mechant = new ArrayList<Dragon>();
//        mechant.add(new Dragon());
//        mechant.add(new Gobelin());


        Menu menu = new Menu();
        menu.welcome();

    }

}
