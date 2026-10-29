package com.lagoa.model.quacks;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silêncio >>");
    }
}