package Gestor.import_tdf.service.impl;

import Gestor.import_tdf.dto.DashboardGeneralDTO;
import Gestor.import_tdf.dto.DashboardResumenDTO;
import Gestor.import_tdf.dto.DashboardVendedorDTO;
import Gestor.import_tdf.entity.Vendedor;
import Gestor.import_tdf.enums.TipoPeriodo;
import Gestor.import_tdf.repository.VendedorRepository;
import Gestor.import_tdf.repository.VentaRepository;
import Gestor.import_tdf.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Override
    public DashboardGeneralDTO obtenerResumenDelDia(TipoPeriodo tipoPeriodo) {

        LocalDate fechaActual = LocalDate.now();

        LocalDate fechaInicio;
        LocalDate fechaFin;

        if (tipoPeriodo == TipoPeriodo.DIA) {
            fechaInicio = fechaActual;
            fechaFin = fechaActual;
        } else if (tipoPeriodo == TipoPeriodo.SEMANA) {
            fechaInicio = fechaActual.with(DayOfWeek.MONDAY);
            fechaFin = fechaActual.with(DayOfWeek.SUNDAY);
        } else {
            fechaInicio = fechaActual.withDayOfMonth(1);
            fechaFin = fechaActual.withDayOfMonth(fechaActual.lengthOfMonth());
        }

        Long cantidadVentas = ventaRepository.contarVentasEntreFechas(fechaInicio, fechaFin);

        Long productosVendidos = ventaRepository.contarProductosVendidosEntreFechas(fechaInicio, fechaFin);

        BigDecimal ingresosTotales = ventaRepository.sumarIngresosEntreFechas(fechaInicio, fechaFin);

        BigDecimal gananciaTotal = ventaRepository.sumarGananciasEntreFechas(fechaInicio, fechaFin);

        DashboardResumenDTO totalNegocio = new DashboardResumenDTO(
                cantidadVentas,
                productosVendidos,
                ingresosTotales,
                gananciaTotal
        );

        List<DashboardVendedorDTO> totalesPorVendedor = new ArrayList<>();

        List<Vendedor> vendedores = vendedorRepository.findAll();

        for (Vendedor vendedor : vendedores) {

            DashboardVendedorDTO vendedorDTO = new DashboardVendedorDTO(
                    vendedor.getId(),
                    vendedor.getNombre(),
                    ventaRepository.contarVentasEntreFechasPorVendedor(fechaInicio, fechaFin, vendedor.getId()),
                    ventaRepository.contarProductosVendidosEntreFechasPorVendedor(fechaInicio, fechaFin, vendedor.getId()),
                    ventaRepository.sumarIngresosEntreFechasPorVendedor(fechaInicio, fechaFin, vendedor.getId()),
                    ventaRepository.sumarGananciasEntreFechasPorVendedor(fechaInicio, fechaFin, vendedor.getId())
            );

            totalesPorVendedor.add(vendedorDTO);
        }

        return new DashboardGeneralDTO(totalNegocio, totalesPorVendedor);
    }
}
