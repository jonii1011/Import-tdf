package Gestor.import_tdf.controller;


import Gestor.import_tdf.entity.GastoNegocio;
import Gestor.import_tdf.service.GastoNegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gastos")
public class GastoNegocioController {

    @Autowired
    private GastoNegocioService gastoNegocioService;

    @GetMapping
    public List<GastoNegocio> listarGastos() {
        return gastoNegocioService.listarGastos();
    }

    @GetMapping("/{id}")
    public GastoNegocio buscarPorId(@PathVariable Long id) {
        return gastoNegocioService.buscarPorId(id);
    }

    @PostMapping
    public GastoNegocio crearGasto(@RequestBody GastoNegocio gastoNegocio) {
        return gastoNegocioService.crearGasto(gastoNegocio);
    }

    @PutMapping("/{id}")
    public GastoNegocio actualizarGasto(
            @PathVariable Long id,
            @RequestBody GastoNegocio gastoActualizado
    ) {
        return gastoNegocioService.actualizarGasto(id, gastoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarGasto(@PathVariable Long id) {
        gastoNegocioService.eliminarGasto(id);
    }
}
