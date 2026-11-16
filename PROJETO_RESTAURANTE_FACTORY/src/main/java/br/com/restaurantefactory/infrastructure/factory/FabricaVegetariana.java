package br.com.restaurantefactory.infrastructure.factory;

import br.com.restaurantefactory.domain.factory.FabricaRefeicao;
import br.com.restaurantefactory.domain.model.Bebida;
import br.com.restaurantefactory.domain.model.PratoPrincipal;
import br.com.restaurantefactory.domain.model.Sobremesa;
import br.com.restaurantefactory.infrastructure.vegetariana.LasanhaDeLegumes;
import br.com.restaurantefactory.infrastructure.vegetariana.MousseMaracuja;
import br.com.restaurantefactory.infrastructure.vegetariana.SucoVerde;

public class FabricaVegetariana implements FabricaRefeicao {
    @Override
    public PratoPrincipal criarPratoPrincipal() {
        return new LasanhaDeLegumes();
    }

    @Override
    public Bebida criarBebida() {
        return new SucoVerde();
    }

    @Override
    public Sobremesa criarSobremesa() {
        return new MousseMaracuja();
    }
}