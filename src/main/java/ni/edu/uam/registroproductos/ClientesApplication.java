package ni.edu.uam.registroproductos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientesApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("clientes-view.fxml"));
        primaryStage.setTitle("Bienvenidos a la pestaña de vlei");
        primaryStage.setScene(new javafx.scene.Scene(loader.load()));
        primaryStage.show();
    }
}
