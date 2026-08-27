package br.com.aula_3.visao;

import br.com.aula_3.modelo.Veiculo;
import br.com.aula_3.service.VeiculoService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private Label lblPista;

    @FXML
    private Label lblResultado;

    private final VeiculoService veiculoService = new VeiculoService();

    // Método executado automaticamente quando a tela é carregada
    @FXML
    public void initialize() {
        lblPista.setText("Local atual: " + veiculoService.getNomePista());
    }

    @FXML
    protected void onAcelerarCarroClick() {
        Veiculo carro = veiculoService.listarTodos().get(0);
        String mensagem = veiculoService.acionarAceleracao(carro);
        lblResultado.setText(mensagem);
    }

    @FXML
    protected void onAcelerarBicicletaClick() {
        Veiculo bici = veiculoService.listarTodos().get(1);
        String mensagem = veiculoService.acionarAceleracao(bici);
        lblResultado.setText(mensagem);
    }
}