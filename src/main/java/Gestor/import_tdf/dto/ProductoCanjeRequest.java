package Gestor.import_tdf.dto;

import Gestor.import_tdf.enums.CategoriaProducto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoCanjeRequest {

    private String nombre;
    private CategoriaProducto categoria;
    private String marca;
    private String modelo;
    private String capacidad;
    private String color;

    private BigDecimal valorTomadoPesos;
    private BigDecimal precioVentaEstimadoPesos;

    private String observacion;
}
