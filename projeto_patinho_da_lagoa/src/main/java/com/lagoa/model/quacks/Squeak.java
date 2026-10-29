package com.lagoa.model.quacks;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak (Borracha)!");
    }
}