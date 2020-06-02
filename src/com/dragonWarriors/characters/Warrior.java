package com.dragonWarriors.characters;

/**
 * Classe fille de la classe Character. Permet l'instanciation d'un Character spécifique appelé Warrior.
 */
public class Warrior extends Character {

    /**
     * Constructeur de la classe. Initialisation de la classe Warrior via le constructeur du parent Character
     * en spécifiant les caractéristiques du Warrior.
     */
    public Warrior(String name) {
        super(name, 5, 5);
        this.sayHello();
    }

    /**
     * Méthode de présentation du personnage instancié. Indication sur sa classe et son nom.
     */
    public void sayHello() {
        System.out.println("I am a strong " + this.getClass().getSimpleName() + ", my name is " + this.getName() + ".");
    }

}
