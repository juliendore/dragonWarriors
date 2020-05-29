package com.dragonWarriors.enemies;

import com.dragonWarriors.EmptyCase;
import com.dragonWarriors.Game;
import com.dragonWarriors.Menu;
import com.dragonWarriors.interfaces.Fight;
import com.dragonWarriors.interfaces.HpInteraction;
import com.dragonWarriors.interfaces.Case;
import com.dragonWarriors.characters.Character;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe abstraite qui permet l'instanciation d'un ennemi et la gestion d'un combat avec ce dernier.
 */
public abstract class Enemy implements Case, HpInteraction, Fight {


    /**
     * Nom de l'ennemi
     */
    private String name;


    /**
     * Points de vie de l'ennemi
     */
    private int hp;


    /**
     * Force de l'ennemi
     */
    private int strength;


    /**
     * Constructeur de la classe.
     */
    public Enemy() {

    }

    /**
     * Constructeur de la classe.
     *
     * @param name nom de l'ennemi.
     */
    public Enemy(String name) {
        this.name = name;
    }

    /**
     * Constructeur complet de la classe.
     *
     * @param name     nom de l'ennemi
     * @param hp       points de vie de l'ennemi
     * @param strength force de l'ennemi
     */
    public Enemy(String name, int hp, int strength) {
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
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    /**
     * Méthode d'interaction : ici permet d'afficher le nom de l'ennemi et de lancer un combat.
     *
     * @param player personnage instancié pour la partie.
     * @param board  plateau de jeu instancié pour la partie.
     * @param game   partie de jeu instanciée.
     */
    @Override
    public void doThis(Character player, ArrayList board, Game game) {
        System.out.println("I am the " + this.getName() + ".");
        fight(player, board, game);

    }

    /**
     * Méthode d'interaction liée au combat. Permet d'afficher les statistiques de l'ennemi. De l'attaquer ou de fuir.
     * En cas d'attaque, l'ennemi attaque à son tour via l'appel de méthode hpInteraction(). Si l'ennemi est encore
     * vivant, l'utilisateur peut choisir d'attaquer à nouveau ou de fuir. Si l'ennemi meurt, fin du combat, la case
     * devient une EmptyCase.
     * <p>
     * En cas d'attaque, les dégats infligés sont calculés à partir d'un coefficient appliqué à la force du personnage.
     * En cas de fuite, le personnage recule d'une case sur le plateau, et un nouveau de jeu commence.
     *
     * @param player personnage instancié pour la partie.
     * @param board  plateau instancié pour la partie.
     * @param game   partie de jeu instanciée.
     */
    @Override
    public void fight(Character player, ArrayList board, Game game) {
        System.out.println("Enemy's stats :");
        System.out.println("  |  Hp : " + this.getHp());
        System.out.println("  |  Strength : " + this.getStrength());
        System.out.println("===============");
        System.out.println("What do you want to do");
        System.out.println("    fight");
        System.out.println("    flee");
        System.out.println("===============");
        Scanner input = new Scanner(System.in);
        String userinput = input.nextLine();
        switch (userinput) {
            case "fight":
                int damage = (int) (player.getStrength() * 0.6);
                System.out.println("Take this ! You make " + damage + " hp of damage to " + this.getName() + ".");
                this.setHp(this.getHp() - damage);
                if (this.getHp() > 0) {
                    this.hpInteraction(player);
                    this.fight(player, board, game);
                } else if (this.getHp() <= 0) {
                    System.out.println("You've killed your enemy.");
                    board.set(board.indexOf(this), new EmptyCase());
                }
                break;
            case "flee":
                if (game.getPos() > 1) {
                    System.out.println("You choose to run away ! You have to go back.");
                    game.setPos(game.getPos() - 1);
                    game.play(player);
                } else {
                    System.out.println("You can't run away ! You have to face your enemy");
                    this.fight(player, board, game);
                }
                break;
            case "quit":
                Menu.caseQuit();
                break;
            default:
                System.out.println("Incorrect entry.");
                this.fight(player, board, game);
        }

    }

    /**
     * Méthode d'interaction en cas d'attaque de l'ennemi. Les dégats reçus sont calculés à partir d'un coefficient
     * appliqué à la force de l'ennemi puis appliqué à la vie du personnage.
     * En cas de mort du personnage : message de gameover et fin de la partie.
     *
     * @param player personnage instancié pour la partie.
     */
    @Override
    public void hpInteraction(Character player) {
        int damage = (int) (this.getStrength() * 0.4);
        player.setHp(player.getHp() - damage);
        System.out.println("Here is the " + this.getName() + "'s attack. You take " + damage + " hp of damage.");
        if (player.getHp() <= 0) {
            System.out.println("                     _           _");
            System.out.println("                   _/ \\ _______ / \\_ ");
            System.out.println("                  /  __/__   __\\__  \\");
            System.out.println("                   \\_/____ \\ / ____\\_/");
            System.out.println("                    //    \\___/    \\\\");
            System.out.println("                   | |   o _ _ o   | |");
            System.out.println("                    \\_\\___/ V \\___/_/");
            System.out.println("                    < `    | |    ' >");
            System.out.println("                     \\__.  \\^/  .__/");
            System.out.println("                       >         <");
            System.out.println("                       [_I_I_I_I_]");
            System.out.println("                      /  /   \\  \\");
            System.out.println("                    _/  /     \\  \\_");
            System.out.println("                   /   <       >   \\");
            System.out.println("                   \\_.  |     |  ._/");
            System.out.println("                     \\_/       \\_/");

            System.out.println("  ________                                                  ");
            System.out.println(" /  _____/_____    _____   ____     _______  __ ___________ ");
            System.out.println("/   \\  ___\\__  \\  /     \\_/ __ \\   /  _ \\  \\/ // __ \\_  __ \\");
            System.out.println("\\    \\_\\  \\/ __ \\|  Y Y  \\  ___/  (  <_> )   /\\  ___/|  | \\/");
            System.out.println(" \\______  (____  /__|_|  /\\___  >  \\____/ \\_/  \\___  >__|   ");
            System.out.println("        \\/     \\/      \\/     \\/                   \\/       ");


            System.exit(0);
        }
        System.out.println("Your stats :");
        System.out.println("  |  Hp : " + player.getHp());
        System.out.println("  |  Strength : " + player.getStrength());
    }
}
