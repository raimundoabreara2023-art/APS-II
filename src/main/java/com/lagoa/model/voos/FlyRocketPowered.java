package com.lagoa.model.voos;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Estou voando com um foguete!");
    }
}