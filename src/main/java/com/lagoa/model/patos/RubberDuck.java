package com.lagoa.model.patos;

import com.lagoa.model.quacks.Squeak;
import com.lagoa.model.voos.FlyNoWay;

public class RubberDuck extends Duck {

    public RubberDuck() {
        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("Eu sou um Pato de Borracha!");
    }
}