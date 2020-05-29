package com.dragonWarriors.characters;

/**
 * Classe fille de la classe Character. Permet l'instanciation d'un Character spécifique appelé Wizard.
 */
public class Wizard extends Character {

    /**
     * Constructeur de la classe. Initialisation de la classe Wizard via le constructeur du parent Character
     * en spécifiant les caractéristiques du Wizard.
     */
    public Wizard(String name) {
        super(name, 3, 8);
    }

    /**
     * Méthode de présentation du personnage instancié. Indication sur sa classe et son nom.
     */
    public void sayHello() {
        System.out.println("I am a mighty " + this.getClass().getSimpleName() + ", my name is " + this.getName() + ".");
    }

}
