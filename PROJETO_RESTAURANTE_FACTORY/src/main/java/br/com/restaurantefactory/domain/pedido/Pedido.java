package br.com.restaurantefactory.domain.pedido;

import br.com.restaurantefactory.domain.model.Bebida;
import br.com.restaurantefactory.domain.model.PratoPrincipal;
import br.com.restaurantefactory.domain.model.Sobremesa;

public class Pedido {
    private final PratoPrincipal pratoPrincipal;
    private final Bebida bebida;
    private final Sobremesa sobremesa;

    public Pedido(PratoPrincipal pratoPrincipal, Bebida bebida, Sobremesa sobremesa) {
        this.pratoPrincipal = pratoPrincipal;
        this.bebida = bebida;
        this.sobremesa = sobremesa;
    }

    public PratoPrincipal getPratoPrincipal() {
        return pratoPrincipal;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public Sobremesa getSobremesa() {
        return sobremesa;
    }

    public double getValorTotal() {
        double total = 0;
        if (pratoPrincipal != null) total += pratoPrincipal.getPreco();
        if (bebida != null) total += bebida.getPreco();
        if (sobremesa != null) total += sobremesa.getPreco();
        return total;
    }
}