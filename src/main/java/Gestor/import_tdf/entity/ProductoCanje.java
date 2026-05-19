package Gestor.import_tdf.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoCanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;

    @OneToOne
    @JoinColumn(name = "producto_recibido_id")
    private Producto productoRecibido;

    private BigDecimal valorTomadoPesos;

    private BigDecimal precioVentaEstimadoPesos;

    private String observacion;
}
