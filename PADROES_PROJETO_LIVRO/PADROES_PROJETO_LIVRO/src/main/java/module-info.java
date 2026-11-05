module br.com.padroesprojeto {

    requires javafx.controls;
    requires javafx.fxml;

    exports br.com.padroesprojeto;

    opens br.com.padroesprojeto to javafx.fxml;
    opens br.com.padroesprojeto.controller to javafx.fxml;
}
