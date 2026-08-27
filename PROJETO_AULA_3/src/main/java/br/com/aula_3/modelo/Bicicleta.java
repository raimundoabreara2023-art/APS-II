package br.com.aula_3.modelo;

public class Bicicleta extends Veiculo {
    private int quantidadeMarchas;

    public Bicicleta(String marca, String modelo, int quantidadeMarchas) {
        super(marca, modelo);
        this.quantidadeMarchas = quantidadeMarchas;
    }

    @Override
    public void acelerar() {
        System.out.println("A bicicleta " + getModelo() + " está pedalando mais rápido! Zummm!");
    }

    public int getQuantidadeMarchas() {
        return quantidadeMarchas;
    }

    public void setQuantidadeMarchas(int quantidadeMarchas) {
        this.quantidadeMarchas = quantidadeMarchas;
    }
}