package br.com.veiculo.service;

import br.com.veiculo.modelo.Veiculo;
import java.util.ArrayList;
import java.util.List;

public class VeiculoService {
    private List<Veiculo> listaVeiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        if (veiculo != null) {
            listaVeiculos.add(veiculo);
        }
    }

    public List<Veiculo> listarVeiculos() {
        return listaVeiculos;
    }
}