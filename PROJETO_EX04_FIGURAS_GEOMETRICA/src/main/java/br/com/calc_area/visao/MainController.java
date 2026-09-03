package br.com.calc_area.visao;

import br.com.calc_area.modelo.Losango;
import br.com.calc_area.modelo.Triangulo;
import br.com.calc_area.service.GerenteDeFiguras;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MainController {

    @FXML
    private TextArea txtAreaResultado;

    @FXML
    private void handleExecutarAcao() {
        GerenteDeFiguras gerente = new GerenteDeFiguras();
        
        // Adicionando figuras iniciais e os dois losangos solicitados
        Triangulo t1 = new Triangulo(2.0, 3.0);
        gerente.adicionaFigura(t1);
        gerente.adicionaFigura(new Losango(4.0, 5.0));
        gerente.adicionaFigura(new Losango(6.0, 8.0));

        // Coletando dados para exibição na tela
        StringBuilder sb = new StringBuilder();
        sb.append("--- LISTA DE FIGURAS ---\n");
        sb.append(gerente.imprimeFiguras());
        sb.append("\n-------------------------\n");
        sb.append(String.format("Área Total: %.2f\n", gerente.calculaAreaTotalDeFiguras()));
        sb.append(String.format("Maior Área: %.2f\n", gerente.getMaiorAreaDeFigura()));

        txtAreaResultado.setText(sb.toString());
    }
}