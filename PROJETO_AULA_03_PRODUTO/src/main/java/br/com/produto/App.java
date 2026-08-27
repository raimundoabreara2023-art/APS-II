package br.com.produto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Atualizado para buscar dentro de br/com/produto/
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/br/com/produto/MainView.fxml"));
        
        Scene scene = new Scene(fxmlLoader.load(), 450, 320);
        stage.setTitle("PROJETO - Herança e Interfaces (Produtos)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}