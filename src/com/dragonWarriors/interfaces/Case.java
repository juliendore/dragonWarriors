package com.dragonWarriors.interfaces;

import com.dragonWarriors.Game;
import com.dragonWarriors.characters.Character;
import java.util.ArrayList;

/**
 * Interface Case de base qui sera implementee par tous les objets presents sur le plateau.
 */
public interface Case {

    /**
     * Méthode abstraite d'interaction entre le joueur et la case du plateau.
     *
     * @param player personnage instancié pour la partie.
     * @param board plateau de jeu instancié pour la partie.
     * @param game partie de jeu instanciée.
     */
    public void doThis(Character player, ArrayList board, Game game);

}
