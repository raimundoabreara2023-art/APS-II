package br.com.restaurantefactory.infrastructure.vegetariana;

import br.com.restaurantefactory.domain.model.Sobremesa;

public class MousseMaracuja implements Sobremesa {
    @Override
    public String getNome() {
        return "Mousse de Maracujá Vegano";
    }

    @Override
    public String getDescricao() {
        return "Mousse cremoso de maracujá preparado com ingredientes de origem vegetal.";
    }

    @Override
    public double getPreco() {
        return 11.00;
    }

    @Override
    public String getImagem() {
        // Arquivo ainda não existe na pasta images: enquanto isso o card mostra o emoji.
        return "/br/com/restaurantefactory/images/vegetariana_mousse.png";
    }
}
