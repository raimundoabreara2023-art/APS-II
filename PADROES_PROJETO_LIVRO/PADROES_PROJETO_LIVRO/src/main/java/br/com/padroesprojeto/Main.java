
package br.com.padroesprojeto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                Main.class.getResource(
                        "/br/com/padroesprojeto/fxml/principal.fxml"
                )
        );

        Parent root = loader.load();

        Scene scene = new Scene(root, 850, 650);

        scene.getStylesheets().add(
                Main.class.getResource(
                        "/br/com/padroesprojeto/css/estilos.css"
                ).toExternalForm()
        );

        stage.setTitle("Fábrica de Chocolate - Padrão Singleton");
        stage.setScene(scene);
        stage.setMinWidth(750);
        stage.setMinHeight(580);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
