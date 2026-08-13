package br.com.agenda_aniver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Carrega o arquivo FXML da pasta de recursos
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("MainView.fxml"));
        
        // Configura a cena com largura de 400 e altura de 300 pixels
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        
        stage.setTitle("Agenda de Aniversários");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}