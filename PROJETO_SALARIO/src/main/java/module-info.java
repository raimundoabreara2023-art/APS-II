module br.com.novo_salario {
    requires javafx.controls;
    requires javafx.fxml;

    exports br.com.novo_salario;
    opens br.com.novo_salario.visao to javafx.fxml;
}