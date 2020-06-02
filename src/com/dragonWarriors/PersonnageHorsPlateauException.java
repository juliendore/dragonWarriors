package com.dragonWarriors;

/**
 * Classe fille de la classe Exception, permet de déclarer une potentielle exception à attraper.
 */
public class PersonnageHorsPlateauException extends Exception {
    /**
     * Constructeur de classe. Cette méthode sera appelée si j'attrape cette exception.
     */
    public PersonnageHorsPlateauException() {
        System.out.println("You went too far ! Go back to case 50.");
    }
}
