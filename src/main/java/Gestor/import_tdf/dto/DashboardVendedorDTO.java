package Gestor.import_tdf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DashboardVendedorDTO {

    private Long vendedorId;

    private String vendedorNombre;

    private Long cantidadVentas;

    private Long productosVendidos;

    private BigDecimal ingresosTotales;

    private BigDecimal gananciaTotal;
}
