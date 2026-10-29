module com.lagoa {
    // Módulos do JavaFX necessários
    requires javafx.controls;
    requires javafx.fxml;

    // Permite que o JavaFX acesse os arquivos FXML e Controllers via reflexão
    opens com.lagoa to javafx.fxml;
    opens com.lagoa.controller to javafx.fxml;

    // Exporta os pacotes para execução do projeto
    exports com.lagoa;
    exports com.lagoa.controller;
    exports com.lagoa.model.patos;
    exports com.lagoa.model.voos;
    exports com.lagoa.model.quacks;
}