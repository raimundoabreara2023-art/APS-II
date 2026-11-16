package br.com.restaurantefactory.infrastructure.vegetariana;

import br.com.restaurantefactory.domain.model.PratoPrincipal;

public class LasanhaDeLegumes implements PratoPrincipal {
    @Override
    public String getNome() {
        return "Lasanha de Berinjela e Abobrinha";
    }

    @Override
    public String getDescricao() {
        return "Camadas de massa artesanal intercaladas com legumes frescos, molho de tomate caseiro e queijo gratinado.";
    }

    @Override
    public double getPreco() {
        return 30.00;
    }

    @Override
    public String getImagem() {
        return "/br/com/restaurantefactory/images/vegetariana_prato.png";
    }
}
