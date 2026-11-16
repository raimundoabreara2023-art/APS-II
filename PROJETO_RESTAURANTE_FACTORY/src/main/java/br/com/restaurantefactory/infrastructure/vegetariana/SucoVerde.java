package br.com.restaurantefactory.infrastructure.vegetariana;

import br.com.restaurantefactory.domain.model.Bebida;

public class SucoVerde implements Bebida {
    @Override
    public String getNome() {
        return "Suco Verde Detox";
    }

    @Override
    public String getDescricao() {
        return "Feito com couve, limão, gengibre e maçã verde.";
    }

    @Override
    public double getPreco() {
        return 9.50;
    }

    @Override
    public String getImagem() {
        // Arquivo ainda não existe na pasta images: enquanto isso o card mostra o emoji.
        return "/br/com/restaurantefactory/images/vegetariana_suco.png";
    }
}
