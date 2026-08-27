module br.com.aula_3 {
    // Requer os módulos necessários do JavaFX
    requires javafx.controls;
    requires javafx.fxml;

    // Permite que o JavaFX acesse por reflexão a classe App e os controladores
    opens br.com.aula_3 to javafx.graphics;
    opens br.com.aula_3.visao to javafx.graphics, javafx.fxml;

    // Exporta os pacotes principais da aplicação
    exports br.com.aula_3 to javafx.graphics;
    exports br.com.aula_3.visao;
    exports br.com.aula_3.modelo; // Já inclui a nova classe Pista e Veiculos
    exports br.com.aula_3.service;
}