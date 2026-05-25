package Gestor.import_tdf.controller;

import Gestor.import_tdf.entity.Producto;
import Gestor.import_tdf.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // LISTAR TODOS
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Producto buscarPorId(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

    // CREAR
    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Producto actualizarProducto(
            @PathVariable Long id,
            @RequestBody Producto producto
    ) {
        return productoService.actualizarProducto(id, producto);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}
