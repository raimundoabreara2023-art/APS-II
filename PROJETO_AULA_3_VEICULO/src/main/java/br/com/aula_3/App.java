package br.com.aula_3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Como o FXML continua na pasta resources/br/com/aula_3/, o caminho continua o mesmo
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/br/com/aula_3/MainView.fxml"));
        
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setTitle("PROJETO AULA 3 - Herança com Veículos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}