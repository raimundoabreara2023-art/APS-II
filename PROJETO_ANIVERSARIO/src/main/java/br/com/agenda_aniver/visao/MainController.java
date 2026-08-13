package br.com.agenda_aniver.visao;

import br.com.agenda_aniver.dados.MinhaAgendaDeAniversarios;
import br.com.agenda_aniver.modelo.Aniversariante;
import br.com.agenda_aniver.modelo.DataAniversario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    @FXML private TextField txtNome;
    @FXML private TextField txtDia;
    @FXML private TextField txtMes;
    @FXML private Label lblMensagem;

    @FXML private TableView<Aniversariante> tabelaAniversariantes;
    @FXML private TableColumn<Aniversariante, String> colunaNome;
    @FXML private TableColumn<Aniversariante, DataAniversario> colunaData;

    private MinhaAgendaDeAniversarios agenda = new MinhaAgendaDeAniversarios();
    private ObservableList<Aniversariante> listaObservable;
    private Aniversariante aniversarianteSelecionado = null;

    @FXML
    public void initialize() {
        // Configura as colunas da tabela
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));

        // Inicializa a lista observável vinculada à agenda
        listaObservable = FXCollections.observableArrayList(agenda.getAniversariantes());
        tabelaAniversariantes.setItems(listaObservable);
    }

    @FXML
    public void handleCadastrar() {
        try {
            String nome = txtNome.getText();
            int dia = Integer.parseInt(txtDia.getText());
            int mes = Integer.parseInt(txtMes.getText());

            Aniversariante novo = new Aniversariante(nome, dia, mes);
            agenda.adicionarAniversariante(novo);
            
            atualizarTabela();
            limparCampos();
            lblMensagem.setText("Cadastrado com sucesso!");
        } catch (NumberFormatException e) {
            lblMensagem.setText("Erro: Dia e Mês devem ser números.");
        }
    }

    @FXML
    public void handleSelecionarTabela() {
        aniversarianteSelecionado = tabelaAniversariantes.getSelectionModel().getSelectedItem();
        if (aniversarianteSelecionado != null) {
            txtNome.setText(aniversarianteSelecionado.getNome());
            txtDia.setText(String.valueOf(aniversarianteSelecionado.getData().getDia()));
            txtMes.setText(String.valueOf(aniversarianteSelecionado.getData().getMes()));
        }
    }

    @FXML
    public void handleAlterar() {
        if (aniversarianteSelecionado != null) {
            try {
                // Remove o antigo e adiciona o atualizado na agenda
                agenda.removerAniversariante(aniversarianteSelecionado);

                String novoNome = txtNome.getText();
                int novoDia = Integer.parseInt(txtDia.getText());
                int novoMes = Integer.parseInt(txtMes.getText());

                Aniversariante atualizado = new Aniversariante(novoNome, novoDia, novoMes);
                agenda.adicionarAniversariante(atualizado);

                atualizarTabela();
                limparCampos();
                aniversarianteSelecionado = null;
                lblMensagem.setText("Registro alterado com sucesso!");
            } catch (NumberFormatException e) {
                lblMensagem.setText("Erro nos valores numéricos da data.");
            }
        } else {
            lblMensagem.setText("Selecione um item na tabela para alterar.");
        }
    }

    @FXML
    public void handleRemover() {
        if (aniversarianteSelecionado != null) {
            // A remoção utiliza internamente o equals() implementado na classe Aniversariante
            agenda.removerAniversariante(aniversarianteSelecionado);
            
            atualizarTabela();
            limparCampos();
            aniversarianteSelecionado = null;
            lblMensagem.setText("Removido com sucesso!");
        } else {
            lblMensagem.setText("Selecione um item na tabela para remover.");
        }
    }

    private void atualizarTabela() {
        listaObservable.setAll(agenda.getAniversariantes());
    }

    private void limparCampos() {
        txtNome.clear();
        txtDia.clear();
        txtMes.clear();
    }
}