package br.com.restaurantefactory.infrastructure.fitness;

import br.com.restaurantefactory.domain.model.Bebida;

public class SucoNatural implements Bebida {
    @Override
    public String getNome() {
        return "Suco de Laranja Natural";
    }

    @Override
    public String getDescricao() {
        return "Suco 100% natural espremido na hora, sem adição de açúcar.";
    }

    @Override
    public double getPreco() {
        return 8.50;
    }

    @Override
    public String getImagem() {
        return "/br/com/restaurantefactory/images/fitnees_suco.png";
    }
}
