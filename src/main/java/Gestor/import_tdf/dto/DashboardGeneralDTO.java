package Gestor.import_tdf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DashboardGeneralDTO {

    private DashboardResumenDTO totalNegocio;

    private List<DashboardVendedorDTO> totalesPorVendedor;
}
