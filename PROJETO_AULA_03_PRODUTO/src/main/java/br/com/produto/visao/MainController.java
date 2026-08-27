package br.com.produto.visao;

import br.com.produto.modelo.Produto;
import br.com.produto.service.ProdutoService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private Label lblSubtitulo;

    @FXML
    private Label lblResultado;

    private final ProdutoService produtoService = new ProdutoService();

    @FXML
    public void initialize() {
        lblSubtitulo.setText("Total de produtos cadastrados: " + produtoService.listarProdutos().size());
    }

    @FXML
    protected void onVerLivroClick() {
        // Pega o primeiro item (Livro) da lista
        Produto livro = produtoService.listarProdutos().get(0);
        String mensagem = produtoService.interagirComProduto(livro);
        lblResultado.setText(mensagem);
    }

    @FXML
    protected void onReproduzirCdClick() {
        // Pega o segundo item (CD) da lista
        Produto cd = produtoService.listarProdutos().get(1);
        String mensagem = produtoService.interagirComProduto(cd);
        lblResultado.setText(mensagem);
    }
}