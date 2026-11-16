package br.com.restaurantefactory.infrastructure.factory;

import br.com.restaurantefactory.domain.factory.FabricaRefeicao;
import br.com.restaurantefactory.domain.model.Bebida;
import br.com.restaurantefactory.domain.model.PratoPrincipal;
import br.com.restaurantefactory.domain.model.Sobremesa;
import br.com.restaurantefactory.infrastructure.tradicional.FileComArrozFeijao;
import br.com.restaurantefactory.infrastructure.tradicional.Pudim;
import br.com.restaurantefactory.infrastructure.tradicional.Refrigerante;

public class FabricaTradicional implements FabricaRefeicao {
    @Override
    public PratoPrincipal criarPratoPrincipal() {
        return new FileComArrozFeijao();
    }

    @Override
    public Bebida criarBebida() {
        return new Refrigerante();
    }

    @Override
    public Sobremesa criarSobremesa() {
        return new Pudim();
    }
}