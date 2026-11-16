package br.com.restaurantefactory.infrastructure.tradicional;

import br.com.restaurantefactory.domain.model.Bebida;

public class Refrigerante implements Bebida {
    @Override
    public String getNome() {
        return "Refrigerante Lata";
    }

    @Override
    public String getDescricao() {
        return "Refrigerante gelado em lata de 350ml.";
    }

    @Override
    public double getPreco() {
        return 6.00;
    }

    @Override
    public String getImagem() {
        return "/br/com/restaurantefactory/images/tradicional_coca_cola.png";
    }
}
