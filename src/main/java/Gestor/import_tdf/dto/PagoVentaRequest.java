package Gestor.import_tdf.dto;

import Gestor.import_tdf.enums.MetodoPago;
import Gestor.import_tdf.enums.Moneda;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PagoVentaRequest {

    private MetodoPago metodoPago;

    private Moneda moneda;

    private BigDecimal monto;

    private BigDecimal cotizacionUsada;
}
