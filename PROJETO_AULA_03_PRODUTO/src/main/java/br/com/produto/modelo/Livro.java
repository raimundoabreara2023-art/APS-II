package br.com.produto.modelo;

public class Livro extends Produto {
    private String autor;

    public Livro(String nome, double preco, String autor) {
        super(nome, preco);
        this.autor = autor;
    }

    @Override
    public String detalhes() {
        return "Livro: " + nome + " | Autor: " + autor + " | Preço: R$ " + preco;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}