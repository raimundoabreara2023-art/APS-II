
package br.com.padroesprojeto.controller;

import br.com.padroesprojeto.service.FabricaChocolateService;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CaldeiraController {

    @FXML
    private Label lblEstado;

    @FXML
    private Label lblMensagem;

    @FXML
    private Label lblIdentidade;

    private FabricaChocolateService service;

    @FXML
    public void initialize() {
        service = new FabricaChocolateService();

        atualizarEstado();

        lblMensagem.setText(
                "Sistema iniciado. A caldeira está pronta para uso."
        );

        lblIdentidade.setText(
                "Instância da caldeira: " +
                Integer.toHexString(
                        System.identityHashCode(service.getCaldeira())
                )
        );
    }

    @FXML
    private void encherCaldeira() {
        exibirResultado(service.encherCaldeira());
    }

    @FXML
    private void aquecerChocolate() {
        exibirResultado(service.aquecerChocolate());
    }

    @FXML
    private void retirarChocolate() {
        exibirResultado(service.retirarChocolate());
    }

    @FXML
    private void consultarEstado() {
        exibirResultado(
                "Estado atual: " + service.consultarEstado()
        );
    }

    private void exibirResultado(String mensagem) {
        lblMensagem.setText(mensagem);
        atualizarEstado();
    }

    private void atualizarEstado() {
        lblEstado.setText(service.consultarEstado());
    }
}
