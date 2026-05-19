package Gestor.import_tdf.entity;

import Gestor.import_tdf.enums.*;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private CategoriaProducto categoria;

    private String marca;

    private String modelo;

    private String capacidad;

    private String color;

    @Enumerated(EnumType.STRING)
    private EstadoProducto estadoProducto;

    @Enumerated(EnumType.STRING)
    private EstadoStock estadoStock;

    @Enumerated(EnumType.STRING)
    private OrigenProducto origenProducto;

    private BigDecimal precioCostoUsd;

    private BigDecimal precioCostoPesos;

    private BigDecimal precioVentaPesos;

    private LocalDate fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "venta_origen_canje_id")
    private Venta ventaOrigenCanje;
}
