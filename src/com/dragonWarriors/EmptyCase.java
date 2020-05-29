package com.dragonWarriors;

import com.dragonWarriors.interfaces.Case;
import com.dragonWarriors.characters.Character;

import java.util.ArrayList;

/**
 * Classe qui permet l'instanciation d'une case vide.
 */
public class EmptyCase implements Case {

    /**
     * Constructeur : une case vie est initialisée.
     */
    public EmptyCase() {

    }

    /**
     * Méthode d'interaction : ici permet l'indication que la case est vide.
     *
     * @param player personnage instancié pour la partie.
     * @param board  plateau de jeu instancié pour la partie.
     * @param game   partie de jeu instanciée.
     */
    @Override
    public void doThis(Character player, ArrayList board, Game game) {
        System.out.println("Well... That case is empty. Nothing happens here.");
    }
}
