module br.com.calc_area {
    requires javafx.controls;
    requires javafx.fxml;

    // Permite que o JavaFX acesse as classes e controllers dentro desses pacotes
    opens br.com.calc_area to javafx.fxml;
    opens br.com.calc_area.visao to javafx.fxml;

    exports br.com.calc_area;
    exports br.com.calc_area.visao;
}