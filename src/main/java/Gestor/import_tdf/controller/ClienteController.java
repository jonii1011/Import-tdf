package Gestor.import_tdf.controller;

import Gestor.import_tdf.entity.Cliente;
import Gestor.import_tdf.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // LISTAR TODOS
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    // CREAR
    @PostMapping
    public Cliente crearVendedor(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Cliente actualizarVendedor(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.actualizarCliente(id, cliente);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminarVendedor(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }
}
