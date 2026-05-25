package Gestor.import_tdf.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoVentaRequest {

    private Long productoId;

    private BigDecimal precioVentaPesos;
}
