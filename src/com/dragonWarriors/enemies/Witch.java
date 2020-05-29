package com.dragonWarriors.enemies;

/**
 * Classe fille de la classe Enemy. Permet l'instanciation d'un Enemy spécifique appelé Witch.
 */
public class Witch extends Enemy {

    /**
     * Constructeur de la classe. Initialisation de la classe Witch via le constructeur du parent Enemy en spécifiant
     * les caractéristiques de Witch.
     */
    public Witch() {
        super("witch", 3, 5);
    }
}
