package com.dragonWarriors.enemies;


/**
 * Classe fille de la classe Enemy. Permet l'instanciation d'un Enemy spécifique appelé Dragon.
 */
public class Dragon extends Enemy {

    /**
     * Constructeur de la classe. Initialisation de la classe Dragon via le constructeur du parent Enemy en spécifiant
     * les caractéristiques du Dragon.
     */
    public Dragon() {
        super("dragon", 5, 5);
    }


}
