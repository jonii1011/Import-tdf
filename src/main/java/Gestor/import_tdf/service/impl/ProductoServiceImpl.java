package Gestor.import_tdf.service.impl;

import Gestor.import_tdf.entity.Producto;
import Gestor.import_tdf.repository.ProductoRepository;
import Gestor.import_tdf.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // LISTAR TODOS
    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    // BUSCAR POR ID
    @Override
    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    // CREAR
    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // ACTUALIZAR
    @Override
    public Producto actualizarProducto(Long id, Producto productoActualizado) {

        Producto producto = buscarPorId(id);

        producto.setNombre(productoActualizado.getNombre());
        producto.setCategoria(productoActualizado.getCategoria());
        producto.setMarca(productoActualizado.getMarca());
        producto.setModelo(productoActualizado.getModelo());
        producto.setCapacidad(productoActualizado.getCapacidad());
        producto.setColor(productoActualizado.getColor());
        producto.setEstadoProducto(productoActualizado.getEstadoProducto());
        producto.setStock(productoActualizado.getStock());
        producto.setOrigenProducto(productoActualizado.getOrigenProducto());
        producto.setPrecioCostoUsd(productoActualizado.getPrecioCostoUsd());
        producto.setPrecioCostoPesos(productoActualizado.getPrecioCostoPesos());
        producto.setPrecioVentaPesos(productoActualizado.getPrecioVentaPesos());
        producto.setFechaIngreso(productoActualizado.getFechaIngreso());

        return productoRepository.save(producto);
    }

    // ELIMINAR
    @Override
    public void eliminarProducto(Long id) {

        Producto producto = buscarPorId(id);

        productoRepository.delete(producto);
    }
}