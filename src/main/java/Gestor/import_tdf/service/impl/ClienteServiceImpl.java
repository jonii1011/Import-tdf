package Gestor.import_tdf.service.impl;

import Gestor.import_tdf.entity.Cliente;
import Gestor.import_tdf.repository.ClienteRepository;
import Gestor.import_tdf.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente cliente) {
        Cliente c = buscarPorId(id);
        c.setNombre(cliente.getNombre());
        c.setTelefono(cliente.getTelefono());
        c.setDNI(cliente.getDNI());
        return clienteRepository.save(c);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
