package br.com.produto.modelo;

public class Cd extends Produto implements Reprodutivel {
    private int quantidadeFaixas;

    public Cd(String nome, double preco, int quantidadeFaixas) {
        super(nome, preco);
        this.quantidadeFaixas = quantidadeFaixas;
    }

    @Override
    public String reproduzir() {
        return "Reproduzindo o CD: " + nome + " (" + quantidadeFaixas + " faixas)";
    }

    @Override
    public String detalhes() {
        return "CD: " + nome + " | Faixas: " + quantidadeFaixas + " | Preço: R$ " + preco;
    }

    public int getQuantidadeFaixas() {
        return quantidadeFaixas;
    }

    public void setQuantidadeFaixas(int quantidadeFaixas) {
        this.quantidadeFaixas = quantidadeFaixas;
    }
}