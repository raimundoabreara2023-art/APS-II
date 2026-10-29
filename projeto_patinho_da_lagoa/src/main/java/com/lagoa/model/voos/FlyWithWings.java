package com.lagoa.model.voos;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Estou voando com asas!");
    }
}