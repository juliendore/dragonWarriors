package com.dragonWarriors.interfaces;

import com.dragonWarriors.characters.Character;

/**
 * Interface qui sera implementee par tous les objets impliquant une interaction avec la strength.
 */
public interface StrengthInteraction {

    /**
     * Méthode abstraite d'interaction entre la strength du joueur et la case du plateau.
     *
     * @param player personnage instancié pour la partie.
     */
    public void strengthInteraction(Character player);

}
