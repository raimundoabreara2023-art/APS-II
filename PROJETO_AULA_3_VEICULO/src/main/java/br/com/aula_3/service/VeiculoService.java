package br.com.aula_3.service;

import br.com.aula_3.modelo.Bicicleta;
import br.com.aula_3.modelo.Carro;
import br.com.aula_3.modelo.Pista;
import br.com.aula_3.modelo.Veiculo;

import java.util.List;

public class VeiculoService {

    private final Pista pistaPrincipal;

    public VeiculoService() {
        // Cria uma pista de testes
        this.pistaPrincipal = new Pista("Autódromo Principal");
        
        // Adiciona veículos direto na pista
        pistaPrincipal.adicionarVeiculo(new Carro("Toyota", "Corolla", 4));
        pistaPrincipal.adicionarVeiculo(new Bicicleta("Caloi", "Elite", 21));
    }

    public List<Veiculo> listarTodos() {
        return pistaPrincipal.getVeiculosNaPista();
    }

    public String acionarAceleracao(Veiculo veiculo) {
        if (veiculo == null) {
            return "Nenhum veículo selecionado.";
        }

        if (veiculo instanceof Carro carro) {
            return "O carro " + carro.getModelo() + " pisou fundo na pista " + pistaPrincipal.getNome() + "! Vruummm!";
        } else if (veiculo instanceof Bicicleta bici) {
            return "A bicicleta " + bici.getModelo() + " pedalou forte na pista " + pistaPrincipal.getNome() + "! Zummm!";
        }

        return "O veículo está acelerando.";
    }
    
    public String getNomePista() {
        return pistaPrincipal.getNome();
    }
}