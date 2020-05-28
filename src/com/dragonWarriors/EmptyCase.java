package com.dragonWarriors;

import com.dragonWarriors.interfaces.Case;
import com.dragonWarriors.characters.Character;

import java.util.ArrayList;


public class EmptyCase implements Case {

    public EmptyCase() {

    }

    @Override
    public void doThis(Character player, ArrayList board) {
        System.out.println("Nothing happens here.");
    }
}
