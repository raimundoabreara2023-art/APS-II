package br.com.aula_3.modelo;

public class Veiculo {
    protected String marca;
    protected String modelo;

    // Construtor
    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    // Método acelerar genérico
    public void acelerar() {
        System.out.println("O veículo está acelerando.");
    }

    // Getters e Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}