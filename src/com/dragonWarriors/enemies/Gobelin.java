package com.dragonWarriors.enemies;


/**
 * Classe fille de la classe Enemy. Permet l'instanciation d'un Enemy spécifique appelé Gobelin.
 */
public class Gobelin extends Enemy {

    /**
     * Constructeur de la classe. Initialisation de la classe Gobelin via le constructeur du parent Enemy en spécifiant
     * les caractéristiques du Gobelin.
     */
    public Gobelin() {
        super("gobelin", 5, 3);
    }

}
