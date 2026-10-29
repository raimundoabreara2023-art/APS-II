
package com.lagoa.model.patos;

import com.lagoa.model.quacks.Quack;
import com.lagoa.model.voos.FlyWithWings;

public class RedheadDuck extends Duck {

    public RedheadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("Eu sou um Pato de Cabeça Vermelha!");
    }
}