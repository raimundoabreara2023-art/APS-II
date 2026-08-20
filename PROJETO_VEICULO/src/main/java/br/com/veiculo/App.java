package br.com.veiculo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Carrega o arquivo MainView.fxml localizado nos resources
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/veiculo/MainView.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            
            primaryStage.setTitle("PROJETO_VEICULO - Cadastro");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar o arquivo FXML: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}