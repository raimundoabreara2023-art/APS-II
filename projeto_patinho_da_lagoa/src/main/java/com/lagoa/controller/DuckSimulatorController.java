package com.lagoa.controller;

import com.lagoa.model.patos.*;
import com.lagoa.model.quacks.MuteQuack;
import com.lagoa.model.voos.FlyRocketPowered;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DuckSimulatorController {

    @FXML private ComboBox<String> comboPatos;
    @FXML private TextArea txtConsole;

    private Duck patoAtual;

    @FXML
    public void initialize() {
        comboPatos.setItems(FXCollections.observableArrayList(
            "Pato Real (MallardDuck)",
            "Pato Cabeça Vermelha (RedheadDuck)",
            "Pato de Borracha (RubberDuck)",
            "Pato de Madeira (DecoyDuck)",
            "Pato Modelo (ModelDuck)"
        ));
        comboPatos.getSelectionModel().selectFirst();
        handlePatoSelecionado();
    }

    @FXML
    public void handlePatoSelecionado() {
        String selecionado = comboPatos.getValue();
        if (selecionado == null) return;

        if (selecionado.contains("MallardDuck")) {
            patoAtual = new MallardDuck();
        } else if (selecionado.contains("RedheadDuck")) {
            patoAtual = new RedheadDuck();
        } else if (selecionado.contains("RubberDuck")) {
            patoAtual = new RubberDuck();
        } else if (selecionado.contains("DecoyDuck")) {
            patoAtual = new DecoyDuck();
        } else if (selecionado.contains("ModelDuck")) {
            patoAtual = new ModelDuck();
        }

        log("Pato selecionado: " + patoAtual.getClass().getSimpleName());
    }

    @FXML
    public void handleDisplay() {
        if (patoAtual != null) capturarSaida(() -> patoAtual.display());
    }

    @FXML
    public void handlePerformFly() {
        if (patoAtual != null) capturarSaida(() -> patoAtual.performFly());
    }

    @FXML
    public void handlePerformQuack() {
        if (patoAtual != null) capturarSaida(() -> patoAtual.performQuack());
    }

    @FXML
    public void handleSwim() {
        if (patoAtual != null) capturarSaida(() -> patoAtual.swim());
    }

    @FXML
    public void handleEquiparFoguete() {
        if (patoAtual != null) {
            patoAtual.setFlyBehavior(new FlyRocketPowered());
            log("🚀 Comportamento de voo alterado dinamicamente para FlyRocketPowered!");
        }
    }

    @FXML
    public void handleMutarPato() {
        if (patoAtual != null) {
            patoAtual.setQuackBehavior(new MuteQuack());
            log("🔇 Comportamento de som alterado dinamicamente para MuteQuack!");
        }
    }

    private void capturarSaida(Runnable acao) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        acao.run();

        System.setOut(originalOut);
        log(baos.toString().trim());
    }

    private void log(String mensagem) {
        txtConsole.appendText(mensagem + "\n");
    }
}