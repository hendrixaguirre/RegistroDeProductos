package ni.edu.uam.registroproductos.repository;

import ni.edu.uam.registroproductos.model.Producto;

import java.time.LocalDate;
import java.util.List;

public class ProductoRepository {

    public List<Producto> findAll(){
        return List.of(new Producto(
                    1,
                    "Monitor Samsung",
                    "Tecnológico",
                    6000.63,
                    LocalDate.of(2026, 9, 1),
                    null
                ),
                new Producto(
                        2,
                        "Apiradora",
                        "Hogar",
                        4580.63,
                        LocalDate.of(2026,9,1),
                        null
                ),
                new Producto(
                        3,
                        "Mueble de madera",
                        "Oficina",
                        9500.63,
                        LocalDate.of(2026,9,1),
                        null
                ),
                new Producto(
                        4,
                        "Guante de béisbol",
                        "Deporte",
                        4200.50,
                        LocalDate.of(2026,9,1),
                        null
                ),
                new Producto(
                        5,
                        "Pantalón Levi's",
                        "Ropa y moda",
                        3100.40,
                        LocalDate.of(2026,5,10),
                        null
                )
        );
    }
}
