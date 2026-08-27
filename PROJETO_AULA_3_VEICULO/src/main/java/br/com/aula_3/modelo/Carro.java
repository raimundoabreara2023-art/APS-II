package br.com.aula_3.modelo;

public class Carro extends Veiculo {
    private int quantidadePortas;

    public Carro(String marca, String modelo, int quantidadePortas) {
        super(marca, modelo);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public void acelerar() {
        System.out.println("O carro " + getModelo() + " pisou fundo no acelerador! Vruummm!");
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }
}