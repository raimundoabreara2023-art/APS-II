package br.com.restaurantefactory.infrastructure.factory;

import br.com.restaurantefactory.domain.factory.FabricaRefeicao;
import br.com.restaurantefactory.domain.model.Bebida;
import br.com.restaurantefactory.domain.model.PratoPrincipal;
import br.com.restaurantefactory.domain.model.Sobremesa;
import br.com.restaurantefactory.infrastructure.fitness.FrangoGrelhado;
import br.com.restaurantefactory.infrastructure.fitness.SaladaDeFrutas;
import br.com.restaurantefactory.infrastructure.fitness.SucoNatural;

public class FabricaFitness implements FabricaRefeicao {
    @Override
    public PratoPrincipal criarPratoPrincipal() {
        return new FrangoGrelhado();
    }

    @Override
    public Bebida criarBebida() {
        return new SucoNatural();
    }

    @Override
    public Sobremesa criarSobremesa() {
        return new SaladaDeFrutas();
    }
}