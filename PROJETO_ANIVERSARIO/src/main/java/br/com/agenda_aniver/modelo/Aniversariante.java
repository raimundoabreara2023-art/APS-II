package br.com.agenda_aniver.modelo;

public class Aniversariante {
    private String nome;
    private DataAniversario data;

    // Construtor 1: Recebe o nome, dia e mês separadamente
    public Aniversariante(String nome, int dia, int mes) {
        this.nome = nome;
        this.data = new DataAniversario(dia, mes);
    }

    // Construtor 2: Recebe o nome e o objeto DataAniversario já pronto
    public Aniversariante(String nome, DataAniversario data) {
        this.nome = nome;
        this.data = data;
    }

    public String getNome() { return nome; }
    public DataAniversario getData() { return data; }

    // Método equals exigido na questão 1
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aniversariante outro = (Aniversariante) obj;
        return this.nome.equals(outro.nome) && this.data.equals(outro.data);
    }
}