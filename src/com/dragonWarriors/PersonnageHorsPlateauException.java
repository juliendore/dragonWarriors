package com.dragonWarriors;

public class PersonnageHorsPlateauException extends Exception {

    public PersonnageHorsPlateauException(int pos) {
        System.out.println("Vous avez dépassé la case finale.");
        this.test(pos);
    }

    public int test(int pos) {


        return pos;
    }

}
