package br.com.restaurantefactory.infrastructure.tradicional;

import br.com.restaurantefactory.domain.model.Sobremesa;

public class Pudim implements Sobremesa {
    @Override
    public String getNome() {
        return "Pudim de Leite Condensado";
    }

    @Override
    public String getDescricao() {
        return "Fatia generosa de pudim tradicional com calda de caramelo.";
    }

    @Override
    public double getPreco() {
        return 10.00;
    }

    @Override
    public String getImagem() {
        return "/br/com/restaurantefactory/images/tradicional_pudin.png";
    }
}
