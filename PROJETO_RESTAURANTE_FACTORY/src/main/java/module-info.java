module br.com.restaurantefactory {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics; // <--- Ajustado aqui

    exports br.com.restaurantefactory;
    exports br.com.restaurantefactory.presentation.controller;

    opens br.com.restaurantefactory to javafx.graphics;
    opens br.com.restaurantefactory.presentation.controller to javafx.fxml;
}