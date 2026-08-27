package br.com.aula_3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pista {
    private String nome;
    private List<Veiculo> veiculosNaPista;

    public Pista(String nome) {
        this.nome = nome;
        this.veiculosNaPista = new ArrayList<>();
    }

    // Adiciona um veículo à pista
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculosNaPista.add(veiculo);
    }

    // Retorna a lista de veículos
    public List<Veiculo> getVeiculosNaPista() {
        return veiculosNaPista;
    }

    // Ação coletiva: faz todos os veículos da pista acelerarem
    public List<String> realizarCorrida() {
        List<String> resultados = new ArrayList<>();
        for (Veiculo v : veiculosNaPista) {
            // Aqui entra o polimorfismo: cada veículo chama o seu próprio 'acelerar'
            // Se criarmos um método ou formarmos uma string descritiva:
            resultados.add("O veículo " + v.getModelo() + " (" + v.getMarca() + ") disparou na pista " + nome + "!");
        }
        return resultados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}