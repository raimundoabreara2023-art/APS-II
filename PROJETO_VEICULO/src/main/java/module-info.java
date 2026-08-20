module br.com.veiculo {
    requires javafx.controls;
    requires javafx.fxml;

    // Exporta o pacote onde está a sua classe App, para que o JavaFX possa lançá-la
    exports br.com.veiculo;
    
    // Abre o pacote de visão para o JavaFX FXML conseguir injetar os componentes
    opens br.com.veiculo.visao to javafx.fxml;
}