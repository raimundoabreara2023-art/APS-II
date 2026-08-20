package br.com.veiculo.visao;

import br.com.veiculo.modelo.Carro;
import br.com.veiculo.modelo.Moto;
import br.com.veiculo.modelo.Veiculo;
import br.com.veiculo.service.VeiculoService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class MainController {

    @FXML private ComboBox<String> cbTipoVeiculo;
    @FXML private TextField txtMarca, txtModelo, txtAno, txtPortas, txtCilindradas;
    @FXML private HBox boxPortas, boxCilindradas;
    @FXML private TextArea txtAreaDetalhes;

    // Instancia o serviço de veículos
    private VeiculoService service = new VeiculoService();

    @FXML
    public void initialize() {
        cbTipoVeiculo.setItems(FXCollections.observableArrayList("Carro", "Moto"));
        
        cbTipoVeiculo.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            boolean isCarro = "Carro".equals(newVal);
            boxPortas.setVisible(isCarro);
            boxPortas.setManaged(isCarro);
            boxCilindradas.setVisible(!isCarro);
            boxCilindradas.setManaged(!isCarro);
        });
    }

    @FXML
    private void handleCadastrar() {
        try {
            String tipo = cbTipoVeiculo.getValue();
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            int ano = Integer.parseInt(txtAno.getText());

            Veiculo v;
            if ("Carro".equals(tipo)) {
                int portas = Integer.parseInt(txtPortas.getText());
                v = new Carro(marca, modelo, ano, portas);
            } else {
                int cc = Integer.parseInt(txtCilindradas.getText());
                v = new Moto(marca, modelo, ano, cc);
            }

            // Usa o service para salvar o veículo
            service.adicionarVeiculo(v);
            
            atualizarExibicao();
            limparCampos();

        } catch (NumberFormatException e) {
            alertErro("Erro de Entrada", "Por favor, preencha os campos numéricos corretamente.");
        } catch (Exception e) {
            alertErro("Erro", "Selecione o tipo e preencha todos os campos.");
        }
    }

    private void atualizarExibicao() {
        StringBuilder sb = new StringBuilder();
        // Pega a lista tratada pelo service
        for (Veiculo v : service.listarVeiculos()) {
            sb.append(v.imprimirDetalhes()).append("\n");
        }
        txtAreaDetalhes.setText(sb.toString());
    }

    private void limparCampos() {
        txtMarca.clear();
        txtModelo.clear();
        txtAno.clear();
        txtPortas.clear();
        txtCilindradas.clear();
    }

    private void alertErro(String titulo, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}