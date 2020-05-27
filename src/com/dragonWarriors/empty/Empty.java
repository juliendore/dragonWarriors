package com.dragonWarriors.empty;

import com.dragonWarriors.Case;
import com.dragonWarriors.personnages.Character;


public class Empty implements Case {

    public Empty() {

    }

    @Override
    public void doThis(Character player) {
        System.out.println("Nothing happens here.");
    }
}
