module br.com.produto {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.com.produto to javafx.graphics;
    opens br.com.produto.visao to javafx.graphics, javafx.fxml;

    exports br.com.produto to javafx.graphics;
    exports br.com.produto.visao;
    exports br.com.produto.modelo;
    exports br.com.produto.service;
}