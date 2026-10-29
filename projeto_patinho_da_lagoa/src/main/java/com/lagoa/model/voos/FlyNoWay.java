package com.lagoa.model.voos;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Eu não consigo voar.");
    }
}