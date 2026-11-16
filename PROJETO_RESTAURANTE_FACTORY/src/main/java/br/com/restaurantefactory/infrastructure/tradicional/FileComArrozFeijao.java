package br.com.restaurantefactory.infrastructure.tradicional;

import br.com.restaurantefactory.domain.model.PratoPrincipal;

public class FileComArrozFeijao implements PratoPrincipal {
    @Override
    public String getNome() {
        return "Filé Mignon com Arroz, Feijão e Fritas";
    }

    @Override
    public String getDescricao() {
        return "O clássico brasileiro: arroz branco, feijão carioca, bife acebolado e batatas fritas crocantes.";
    }

    @Override
    public double getPreco() {
        return 35.00;
    }

    @Override
    public String getImagem() {
        return "/br/com/restaurantefactory/images/tradicional_prato.png";
    }
}
