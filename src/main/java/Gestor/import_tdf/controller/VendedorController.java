package Gestor.import_tdf.controller;

import Gestor.import_tdf.entity.Vendedor;
import Gestor.import_tdf.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    // LISTAR TODOS
    @GetMapping
    public List<Vendedor> listarVendedores() {
        return vendedorService.listarVendedores();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Vendedor buscarPorId(@PathVariable Long id) {
        return vendedorService.buscarPorId(id);
    }

    // CREAR
    @PostMapping
    public Vendedor crearVendedor(@RequestBody Vendedor vendedor) {
        return vendedorService.crearVendedor(vendedor);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Vendedor actualizarVendedor(@PathVariable Long id, @RequestBody Vendedor vendedor) {
        return vendedorService.actualizarVendedor(id, vendedor);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminarVendedor(@PathVariable Long id) {
        vendedorService.eliminarVendedor(id);
    }

}
