package Gestor.import_tdf.controller;

import Gestor.import_tdf.dto.DashboardGeneralDTO;
import Gestor.import_tdf.enums.TipoPeriodo;
import Gestor.import_tdf.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/resumen-hoy")
    public DashboardGeneralDTO obtenerResumenDelDia(@RequestParam TipoPeriodo tipo) {
        return dashboardService.obtenerResumenDelDia(tipo);
    }
}
