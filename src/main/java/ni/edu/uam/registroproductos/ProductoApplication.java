package ni.edu.uam.registroproductos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class ProductoApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registro-productos-view.fxml"));
        primaryStage.setTitle("Registro de Productos");
        primaryStage.setScene(new javafx.scene.Scene(loader.load()));
        primaryStage.show();
    }
}
