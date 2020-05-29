package com.dragonWarriors.interfaces;

import com.dragonWarriors.characters.Character;

/**
 * Interface qui sera implementee par tous les objets impliquant une interaction avec les hp.
 */
public interface HpInteraction {

    /**
     * Méthode abstraite d'interaction entre les hp du joueur et la case du plateau.
     *
     * @param player personnage instancié pour la partie.
     */
    public void hpInteraction(Character player);

}
