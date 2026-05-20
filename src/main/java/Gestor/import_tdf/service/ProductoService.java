package Gestor.import_tdf.service;

import Gestor.import_tdf.entity.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> listarProductos();

    Producto buscarPorId(Long id);

    Producto guardarProducto(Producto producto);

    Producto actualizarProducto(Long id, Producto producto);

    void eliminarProducto(Long id);
}