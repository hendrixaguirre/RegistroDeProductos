module ni.edu.uam.registroproductos {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.registroproductos to javafx.fxml;
    exports ni.edu.uam.registroproductos;
    exports ni.edu.uam.registroproductos.controller;
    opens ni.edu.uam.registroproductos.controller to javafx.fxml;
}