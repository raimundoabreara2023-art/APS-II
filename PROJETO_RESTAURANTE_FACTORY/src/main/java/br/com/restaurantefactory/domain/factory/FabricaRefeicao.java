package br.com.restaurantefactory.domain.factory;

import br.com.restaurantefactory.domain.model.Bebida;
import br.com.restaurantefactory.domain.model.PratoPrincipal;
import br.com.restaurantefactory.domain.model.Sobremesa;

public interface FabricaRefeicao {
    PratoPrincipal criarPratoPrincipal();
    Bebida criarBebida();
    Sobremesa criarSobremesa();
}