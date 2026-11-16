package br.com.restaurantefactory.infrastructure.fitness;

import br.com.restaurantefactory.domain.model.Sobremesa;

public class SaladaDeFrutas implements Sobremesa {
    @Override
    public String getNome() {
        return "Salada de Frutas Frescas";
    }

    @Override
    public String getDescricao() {
        return "Mix de frutas da estação selecionadas, leves e refrescantes.";
    }

    @Override
    public double getPreco() {
        return 9.00;
    }

    @Override
    public String getImagem() {
        return "/br/com/restaurantefactory/images/fitnees_salada_frutas.png";
    }
}
