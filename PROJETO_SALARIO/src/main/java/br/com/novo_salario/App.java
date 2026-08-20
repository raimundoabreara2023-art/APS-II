package br.com.novo_salario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // ATENÇÃO AQUI: Certifique-se de que o caminho começa com "/" 
            // e aponta para a localização exata do arquivo FXML dentro de resources.
            Parent root = FXMLLoader.load(getClass().getResource("/br/com/novo_salario/MainView.fxml"));
            
            Scene scene = new Scene(root);
            stage.setTitle("Cálculo de Salário de Funcionários");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar o arquivo FXML: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}