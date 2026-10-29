package com.lagoa.model.patos;

import com.lagoa.model.voos.FlyBehavior;
import com.lagoa.model.quacks.QuackBehavior;

public abstract class Duck {
    // Variáveis de referência para as interfaces de comportamento
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public Duck() {}

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("Todos os patos flutuam, até os de madeira!");
    }

    // Setters para alteração dinâmica de comportamento em tempo de execução
    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }
}