package com.lagoa.model.patos;

import com.lagoa.model.quacks.MuteQuack;
import com.lagoa.model.voos.FlyNoWay;

public class DecoyDuck extends Duck {

    public DecoyDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("Eu sou um Pato de Madeira (Chamariz)!");
    }
}