package br.com.produto.service;

import br.com.produto.modelo.Cd;
import br.com.produto.modelo.Livro;
import br.com.produto.modelo.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private final List<Produto> produtos = new ArrayList<>();

    public ProdutoService() {
        produtos.add(new Livro("Clean Code", 89.90, "Robert C. Martin"));
        produtos.add(new Cd("Álbum de Rock", 45.00, 12));
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public String interagirComProduto(Produto produto) {
        if (produto instanceof Cd cd) {
            return cd.reproduzir() + " - " + cd.detalhes();
        } else if (produto instanceof Livro livro) {
            return livro.detalhes();
        }
        return produto.detalhes();
    }
}