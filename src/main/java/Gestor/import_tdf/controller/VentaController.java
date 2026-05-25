package Gestor.import_tdf.controller;

import Gestor.import_tdf.dto.CrearVentaRequest;
import Gestor.import_tdf.entity.Venta;
import Gestor.import_tdf.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

    @GetMapping("/{id}")
    public Venta buscarPorId(@PathVariable Long id) {
        return ventaService.buscarPorId(id);
    }

    @PostMapping
    public Venta crearVenta(@RequestBody CrearVentaRequest request) {
        return ventaService.crearVenta(request);
    }
}
