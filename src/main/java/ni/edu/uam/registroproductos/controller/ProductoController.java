package ni.edu.uam.registroproductos.controller;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import ni.edu.uam.registroproductos.model.Producto;
import ni.edu.uam.registroproductos.repository.ProductoRepository;

import java.io.File;
import java.time.LocalDate;

public class ProductoController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCategoria;
    @FXML
    private TextField txtPrecio;
    @FXML
    private DatePicker dpFecha;
    @FXML
    private ImageView imgProducto;

    @FXML
    private TableView<Producto> tvProductos;

    @FXML
    private TableColumn<Producto, Integer> colId;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, String> colCategoria;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, LocalDate> colFecha;

    private final ObservableList<Producto> productos = FXCollections.observableArrayList();

    private final ProductoRepository productoRepository = new ProductoRepository();

    private String selectedImagePath;

    @FXML
    private void initialize(){
        configureTable();
        configureDatePicker();
        loadInitializeData();
        configureTableSelection();
    }

    private void configureTable(){
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("Precio"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("Fecha"));

        tvProductos.setItems(productos);

    }

    private void configureDatePicker(){
        dpFecha.setValue(LocalDate.now());
    }

    private void loadInitializeData(){
        productos.clear();
        productos.setAll(productoRepository.findAll());
    }

    private void configureTableSelection(){
        tvProductos.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> {
            if (newvalue != null) {
                loadProductoIntoForm(newvalue);
            }
        });
    }

    private void loadProductoIntoForm(Producto producto){
        txtNombre.setText(producto.getNombre());
        txtCategoria.setText(producto.getCategoria());
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        dpFecha.setValue(producto.getFechaRegistro());
        selectedImagePath = producto.getImagePath();
        // Agregar el método de showImage
    }

    private boolean validateForm(){
        String nombre = txtNombre.getText().trim();
        String categoria = txtCategoria.getText().trim();
        String precio = txtPrecio.getText().trim();

        if(nombre.isEmpty() || categoria.isEmpty() || precio.isEmpty()){
            showAlert(
                    Alert.AlertType.WARNING,
                    "Datos incompletos",
                    "Completa todos los campos para continuar"
            );
            return false;
        }
        return true;
    }

    private void showAlert(Alert.AlertType type, String title, String message){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void agregarProducto(){
        if(!validateForm()){
            return;
        }

        Producto producto = new Producto(
                1,
                txtNombre.getText().trim(),
                txtCategoria.getText().trim(),
                Double.parseDouble(txtPrecio.getText()),
                dpFecha.getValue(),
                selectedImagePath
        );

        productos.add(producto);
        showAlert(
                Alert.AlertType.INFORMATION,
                "Productos creados",
                "Creado con éxito"
        );
    }

    @FXML
    private void selectImage(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccione la imagen del producto");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagenes","*.jpg","*.png","*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(imgProducto.getScene().getWindow());
        if (selectedFile != null){
            selectedImagePath = selectedFile.toURI().toString();
            showImage(selectedImagePath);
        }
    }
}
