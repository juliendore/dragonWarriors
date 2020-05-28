package com.dragonWarriors;

import com.dragonWarriors.interfaces.Case;
import com.dragonWarriors.characters.Character;


public class EmptyCase implements Case {

    public EmptyCase() {

    }

    @Override
    public void doThis(Character player) {
        System.out.println("Nothing happens here.");
    }
}
