package ni.edu.uam.registroproductos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalController {
    @FXML
    private void abrirMenuProductos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ni/edu/uam/registroproductos/registro-productos-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Menú Productos");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void abrirMenuClientes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ni/edu/uam/registroproductos/clientes-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Menú Clientes");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void abrirMenuReporte(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reportes");
        alert.setHeaderText("Registro de reportes");
        alert.setContentText("Aplicación para administrar el catálogo de productos.");
        alert.showAndWait();

    }

}
