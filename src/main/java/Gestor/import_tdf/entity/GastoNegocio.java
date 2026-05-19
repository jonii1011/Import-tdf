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
public class GastoNegocio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private CategoriaGasto categoriaGasto;

    @Enumerated(EnumType.STRING)
    private Moneda moneda;

    private BigDecimal monto;

    private BigDecimal cotizacionUsada;

    private BigDecimal montoConvertidoPesos;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    private String observacion;
}
