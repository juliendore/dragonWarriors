package com.dragonWarriors.interfaces;

import com.dragonWarriors.Game;
import com.dragonWarriors.characters.Character;
import java.util.ArrayList;

/**
 * Interface qui sera implementee par tous les objets impliquant un combat au tour par tour.
 */
public interface Fight {

    /**
     * Méthode abstraite d'interaction entre le joueur, son plateau, sa partie et l'ennemi rencontré.
     *
     * @param player personnage instancié pour la partie.
     * @param board plateau instancié pour la partie.
     * @param game partie de jeu instanciée.
     */
    public void fight(Character player, ArrayList board, Game game);

}
