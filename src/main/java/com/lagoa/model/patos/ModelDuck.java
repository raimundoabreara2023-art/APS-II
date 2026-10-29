package com.lagoa.model.patos;

import com.lagoa.model.quacks.Quack;
import com.lagoa.model.voos.FlyNoWay;

public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("Eu sou um Pato Modelo!");
    }
}