package com.lagoa.model.patos;

import com.lagoa.model.quacks.Quack;
import com.lagoa.model.voos.FlyWithWings;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("Eu sou um Pato Real (Mallard)!");
    }
}