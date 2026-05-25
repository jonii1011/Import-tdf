package Gestor.import_tdf.service;

import Gestor.import_tdf.dto.DashboardGeneralDTO;
import Gestor.import_tdf.enums.TipoPeriodo;

public interface DashboardService {
    DashboardGeneralDTO obtenerResumenDelDia(TipoPeriodo tipoPeriodo);
}
