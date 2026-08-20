package br.com.novo_salario.visao;

import br.com.novo_salario.modelo.*;
import br.com.novo_salario.service.FuncionarioService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class MainController {

    @FXML private ComboBox<String> cbTipoFuncionario;
    @FXML private TextField txtNome, txtMatricula, txtSalarioBase, txtDataAdmissao;
    @FXML private TextField txtVT, txtVA, txtEquipe, txtBonus, txtBolsa, txtCarga;
    @FXML private HBox boxVT, boxVA, boxEquipe, boxBonus, boxBolsa, boxCarga;
    @FXML private TextArea txtAreaDetalhes;

    private FuncionarioService service = new FuncionarioService();

    @FXML
    public void initialize() {
        cbTipoFuncionario.setItems(FXCollections.observableArrayList("Funcionario", "FuncionarioCLT", "Gerente", "Estagiario"));
        
        // Listener para exibir campos conforme o tipo selecionado
        cbTipoFuncionario.getSelectionModel().selectedItemProperty().addListener((obs, old, newVal) -> {
            boolean isCLT = "FuncionarioCLT".equals(newVal);
            boolean isGerente = "Gerente".equals(newVal);
            boolean isEstagiario = "Estagiario".equals(newVal);

            boxVT.setVisible(isCLT || isGerente); boxVT.setManaged(isCLT || isGerente);
            boxVA.setVisible(isCLT || isGerente); boxVA.setManaged(isCLT || isGerente);
            boxEquipe.setVisible(isGerente); boxEquipe.setManaged(isGerente);
            boxBonus.setVisible(isGerente); boxBonus.setManaged(isGerente);
            boxBolsa.setVisible(isEstagiario); boxBolsa.setManaged(isEstagiario);
            boxCarga.setVisible(isEstagiario); boxCarga.setManaged(isEstagiario);
        });
    }

    @FXML
    private void handleCadastrar() {
        try {
            String nome = txtNome.getText();
            String mat = txtMatricula.getText();
            double salBase = Double.parseDouble(txtSalarioBase.getText());
            String data = txtDataAdmissao.getText();

            Funcionario f;
            String tipo = cbTipoFuncionario.getValue();

            if ("Gerente".equals(tipo)) {
                f = new Gerente(nome, mat, salBase, data, Double.parseDouble(txtVT.getText()), Double.parseDouble(txtVA.getText()), Integer.parseInt(txtEquipe.getText()), Double.parseDouble(txtBonus.getText()));
            } else if ("FuncionarioCLT".equals(tipo)) {
                f = new FuncionarioCLT(nome, mat, salBase, data, Double.parseDouble(txtVT.getText()), Double.parseDouble(txtVA.getText()));
            } else if ("Estagiario".equals(tipo)) {
                f = new Estagiario(nome, mat, salBase, data, Double.parseDouble(txtBolsa.getText()), Integer.parseInt(txtCarga.getText()));
            } else {
                f = new Funcionario(nome, mat, salBase, data);
            }

            service.adicionarFuncionario(f);
            atualizarExibicao();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro nos dados. Verifique os campos numéricos.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleCarregarExemplos() {
        service.carregarDadosExemplo();
        atualizarExibicao();
    }

    private void atualizarExibicao() {
        StringBuilder sb = new StringBuilder();
        for (Funcionario f : service.listarFuncionarios()) {
            sb.append(f.toString()).append("\n");
        }
        txtAreaDetalhes.setText(sb.toString());
    }
}