package com.dragonWarriors.empty;

import com.dragonWarriors.Case;

public class Empty implements Case {

    private String name;

    public Empty() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doThis() {
        System.out.println("I ain't doing shit men !");
    }
}
