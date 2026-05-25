package Gestor.import_tdf.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class CrearVentaRequest {

    private LocalDate fecha;

    private Long clienteId;

    private Long vendedorId;

    private BigDecimal cotizacionDolar;

    private String observacion;

    private List<ProductoVentaRequest> productos;

    private List<PagoVentaRequest> pagos;
}
