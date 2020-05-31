package com.dragonWarriors;

import com.dragonWarriors.characters.Warrior;
import com.dragonWarriors.characters.Wizard;
import com.dragonWarriors.enemies.Gobelin;
import com.dragonWarriors.enemies.Witch;
import com.dragonWarriors.potions.BigPotion;
import com.dragonWarriors.enemies.Dragon;
import com.dragonWarriors.interfaces.Case;
import com.dragonWarriors.characters.Character;
import com.dragonWarriors.potions.StandardPotion;
import com.dragonWarriors.spells.Fire;
import com.dragonWarriors.spells.Lightning;
import com.dragonWarriors.weapons.Mace;
import com.dragonWarriors.weapons.Sword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * La classe Game permet de gérer tout le dérouler d'une partie.
 */
public class Game {

    /**
     * Position du joueur sur le plateau.
     */
    private int pos;

    /**
     * Plateau de jeu. Une ArrayList qui contiendra des implémentations de l'interface Case.
     */
    private ArrayList<Case> board = new ArrayList();

    /**
     * Constructeur : initialise la position à 1, génére un plateau de jeu, puis répartit aléatoirement les éléments du
     * plateau.
     */
    public Game() {

        this.pos = 1;

        this.boardSettings(64, 4, 10, 10, 5, 4, 5, 2, 6, 2);

        Collections.shuffle(this.board);

    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    /**
     * Méthode principale des mécaniques de jeu. Renseigne sur la position et les statistiques actuelles du personnage,
     * fais interagir le personnage avec la case sur laquelle il se trouve. Après quoi l'utilisateur relancera le dé
     * pour un nouveau tour de jeu.
     * <p>
     * Gestion de l'exception PersonnageHorsPlateauException au cas où le joueur dépasse la case finale, retour à la
     * position spécifiée dans le bloc catch.
     * <p>
     * Gestion du cas où le joueur termine la partie. Une fois sur la case finale il peut choisir de recommencer une
     * partie (reset position 1 et reset des statistiques) ou de quitter.
     * Possibilite d'acceder a un mode debug pour assigner directement une position specifique au personnage ainsi qu'a
     * une carte.
     *
     * @param player une instance d'une classe fille de la classe Character. Le personnage de l'utilisateur.
     */
    public void play(Character player) {
        System.out.println("Current position > " + this.pos + "/64");
        System.out.println("Your stats :");
        System.out.println("  |  Hp : " + player.getHp());
        System.out.println("  |  Strength : " + player.getStrength());
        this.board.get(this.pos - 1).doThis(player, this.board, this);
        System.out.println("'roll' to roll the dice.");
        System.out.println("===============");
        Scanner input = new Scanner(System.in);
        String userinput = input.nextLine();
        switch (userinput) {
            case "pwd":
                System.out.println(" Case number " + Integer.sum(this.board.indexOf(this.board.get(this.pos - 1)), 1) + " : " + this.board.get(this.pos - 1).getClass().getSimpleName() + " <<< You're here !");
                break;
            case "map":
                for (Case c : this.board
                ) {
                    if (this.pos == Integer.sum(this.board.indexOf(c), 1)) {
                        System.out.println(" Case number " + Integer.sum(this.board.indexOf(c), 1) + " : " + c.getClass().getSimpleName() + " <<< You're here !");
                    } else {
                        System.out.println(" Case number " + Integer.sum(this.board.indexOf(c), 1) + " : " + c.getClass().getSimpleName());
                    }
                }
                break;
            case "debug":
                System.out.println("===============");
                System.out.println("debug mode, type wanted position.");
                input = new Scanner(System.in);
                this.pos = input.nextInt();
                break;
            case "roll":
                try {
                    this.caseRoll();
                } catch (PersonnageHorsPlateauException e) {
                    this.pos = 50;
                }
                break;
            case "quit":
                Menu.caseQuit();
                break;
            default:
                System.out.println("Incorrect entry.");
                this.play(player);
        }
        if (this.pos == 64) {
            System.out.println("Congratulation you've finished ! What do you want to do now ?");
            System.out.println("restart");
            System.out.println("quit");
            input = new Scanner(System.in);
            userinput = input.nextLine();
            switch (userinput) {
                case "restart":
                    this.pos = 1;
                    if (player instanceof Warrior) {
                        System.out.println("here");
                        this.play(new Warrior(player.getName()));
                    } else if (player instanceof Wizard) {
                        this.play(new Wizard(player.getName()));
                    }
                    break;
                case "quit":
                    Menu.caseQuit();
                    break;
                default:
                    System.out.println("Incorrect entry.");
                    this.pos = 64;
            }
        }
        this.play(player);
    }

    /**
     * Méthode de génération du plateau de jeu. Cette méthode permet de générer le nombre voulu de élément du
     * plateau en les renseignants dans les paramètres. Après avoir intégré les cases spéciales, la méthode comble
     * l'écart entre les cases spéciales et le nombre de cases total voulu en créant des cases vides.
     *
     * @param maxcases          Nombre total de cases voulu.
     * @param maxdragon         Nombre de dragons.
     * @param maxgobelin        Nombre de gobelins.
     * @param maxwitch          Nombre de sorcières(witch).
     * @param maxmace           Nombre de massues(mace).
     * @param maxsword          Nombre d'épées(sword).
     * @param maxlighting       Nombre de sorts éclair(lightning).
     * @param maxfire           Nombre de sorts de feu(fire).
     * @param maxstandardpotion Nombre de potions standardes.
     * @param maxbigpotion      Nombre de grandes potions.
     */
    private void boardSettings(int maxcases, int maxdragon, int maxgobelin, int maxwitch, int maxmace, int maxsword,
                               int maxlighting, int maxfire, int maxstandardpotion, int maxbigpotion) {
        int emptycases = maxcases - maxdragon - maxgobelin - maxwitch - maxmace - maxsword - maxlighting - maxfire - maxstandardpotion - maxbigpotion;

        for (int i = 0; i < maxdragon; i++) {
            this.board.add(new Dragon());
        }
        for (int i = 0; i < maxgobelin; i++) {
            this.board.add(new Gobelin());
        }
        for (int i = 0; i < maxwitch; i++) {
            this.board.add(new Witch());
        }
        for (int i = 0; i < maxmace; i++) {
            this.board.add(new Mace("Awesome mace"));
        }
        for (int i = 0; i < maxsword; i++) {
            this.board.add(new Sword("Awesome sword"));
        }
        for (int i = 0; i < maxlighting; i++) {
            this.board.add(new Lightning());
        }
        for (int i = 0; i < maxfire; i++) {
            this.board.add(new Fire());
        }
        for (int i = 0; i < maxstandardpotion; i++) {
            this.board.add(new StandardPotion());
        }
        for (int i = 0; i < maxbigpotion; i++) {
            this.board.add(new BigPotion());
        }
        for (int i = 0; i < emptycases; i++) {
            this.board.add(new EmptyCase());
        }

    }

    /**
     * Cette méthode permet de lancer un dé pour déterminer de combien le joueur peut avancer.
     *
     * @throws PersonnageHorsPlateauException Cas d'exception : Si la somme du lancer de dé et de la position dépasse
     *                                        le nombre total de cases du plateau le personnage sera considéré comme
     *                                        hors du plateau.
     */
    private void caseRoll() throws PersonnageHorsPlateauException {
        int dice1 = 0;
        dice1 = 1 + (int) (Math.random() * 6);
        System.out.println("Dice roll : " + dice1);
        if (this.pos + dice1 > this.board.size()) {
            throw new PersonnageHorsPlateauException();
        }
        for (int i = 0; i < dice1; i++) {
            this.pos++;
        }
    }

}


