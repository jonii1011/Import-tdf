package Gestor.import_tdf.service;


import Gestor.import_tdf.entity.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> listarClientes();

    Cliente buscarPorId(Long id);

    Cliente crearCliente(Cliente cliente);

    Cliente actualizarCliente(Long id, Cliente cliente);
    void eliminarCliente(Long id);
}
