package com.dragonWarriors.characters;

/**
 * Classe abstraite qui permet l'instanciation d'un personnage.
 */
public abstract class Character {

    /**
     * Nom du personnage
     */
    private String name;

    /**
     * Hp du personnage
     */
    private int hp;

    /**
     * Strength du personnage
     */
    private int strength;

    /**
     * Constructeur simple
     */
    public Character() {
    }

    /**
     * Constructeur avec nom
     *
     * @param name Nom du personnage
     */
    public Character(String name) {
        this.name = name;
    }

    /**
     * Constructeur complet avec nom hp et strength
     *
     * @param name     Nom du personnage
     * @param hp       Hp du personnage
     * @param strength Strength du personnage
     */
    public Character(String name, int hp, int strength) {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

}
