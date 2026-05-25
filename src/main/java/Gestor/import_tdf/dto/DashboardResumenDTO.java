package Gestor.import_tdf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DashboardResumenDTO {

    private Long cantidadVentas;

    private Long productosVendidos;

    private BigDecimal ingresosTotales;

    private BigDecimal gananciaTotal;
}
