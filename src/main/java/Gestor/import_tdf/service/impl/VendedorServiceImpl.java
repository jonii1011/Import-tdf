package Gestor.import_tdf.service.impl;

import Gestor.import_tdf.entity.Vendedor;
import Gestor.import_tdf.repository.VendedorRepository;
import Gestor.import_tdf.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorServiceImpl implements VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Override
    public List<Vendedor> listarVendedores() {
        return vendedorRepository.findAll();
    }

    @Override
    public Vendedor buscarPorId(Long id) {
        return vendedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
    }

    @Override
    public Vendedor crearVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @Override
    public Vendedor actualizarVendedor(Long id, Vendedor vendedorActualizado) {
        Vendedor vendedor = buscarPorId(id);

        vendedor.setNombre(vendedorActualizado.getNombre());
        vendedor.setApellido(vendedorActualizado.getApellido());
        vendedor.setTelefono(vendedorActualizado.getTelefono());

        return vendedorRepository.save(vendedor);
    }

    @Override
    public void eliminarVendedor(Long id) {
        Vendedor vendedor = buscarPorId(id);

        vendedorRepository.delete(vendedor);
    }
}
