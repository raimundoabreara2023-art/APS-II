package br.com.restaurantefactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/br/com/restaurantefactory/presentation/view/restaurante-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1500, 1000);
        
        // Carrega a folha de estilos CSS
        String css = Main.class.getResource("/br/com/restaurantefactory/css/estilos.css").toExternalForm();
        scene.getStylesheets().add(css);

        // No seu método start(Stage stage) dentro do Main.java:
        stage.setScene(scene);
        stage.setTitle("Restaurante Factory - Abstract Factory Pattern");
        stage.setMaximized(true); // <-- Adicione esta linha para abrir maximizado
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}