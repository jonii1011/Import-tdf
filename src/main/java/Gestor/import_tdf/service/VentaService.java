package Gestor.import_tdf.service;

import Gestor.import_tdf.dto.CrearVentaRequest;
import Gestor.import_tdf.entity.Venta;

import java.util.List;

public interface VentaService {
    List<Venta> listarVentas();

    Venta buscarPorId(Long id);

    Venta crearVenta(CrearVentaRequest request);
}
