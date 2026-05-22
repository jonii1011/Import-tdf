package Gestor.import_tdf.service;

import Gestor.import_tdf.entity.Vendedor;
import java.util.List;

public interface VendedorService {

    List<Vendedor> listarVendedores();

    Vendedor buscarPorId(Long id);

    Vendedor crearVendedor(Vendedor vendedor);

    Vendedor actualizarVendedor(Long id, Vendedor vendedor);

    void eliminarVendedor(Long id);

}
