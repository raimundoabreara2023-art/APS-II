package br.com.restaurantefactory.infrastructure.fitness;

import br.com.restaurantefactory.domain.model.PratoPrincipal;

public class FrangoGrelhado implements PratoPrincipal {
    @Override
    public String getNome() {
        return "Frango Grelhado com Batata Doce";
    }

    @Override
    public String getDescricao() {
        return "Filé de frango grelhado suculento acompanhado de batata doce assada e brócolis ao vapor.";
    }

    @Override
    public double getPreco() {
        return 28.90;
    }

    @Override
    public String getImagem() {
        return "/br/com/restaurantefactory/images/fitnees_prato.png";
    }
}
