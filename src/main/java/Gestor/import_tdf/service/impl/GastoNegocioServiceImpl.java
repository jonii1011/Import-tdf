package Gestor.import_tdf.service.impl;

import Gestor.import_tdf.entity.GastoNegocio;
import Gestor.import_tdf.repository.GastoNegocioRepository;
import Gestor.import_tdf.service.GastoNegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoNegocioServiceImpl implements GastoNegocioService {

    @Autowired
    private GastoNegocioRepository gastoNegocioRepository;

    @Override
    public List<GastoNegocio> listarGastos() {
        return gastoNegocioRepository.findAll();
    }

    @Override
    public GastoNegocio buscarPorId(Long id) {
        return gastoNegocioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gasto no encontrado"));
    }

    @Override
    public GastoNegocio crearGasto(GastoNegocio gastoNegocio) {
        return gastoNegocioRepository.save(gastoNegocio);
    }

    @Override
    public GastoNegocio actualizarGasto(Long id, GastoNegocio gastoActualizado) {

        GastoNegocio gasto = buscarPorId(id);

        gasto.setFecha(gastoActualizado.getFecha());
        gasto.setDescripcion(gastoActualizado.getDescripcion());
        gasto.setCategoriaGasto(gastoActualizado.getCategoriaGasto());
        gasto.setMoneda(gastoActualizado.getMoneda());
        gasto.setMonto(gastoActualizado.getMonto());
        gasto.setCotizacionUsada(gastoActualizado.getCotizacionUsada());
        gasto.setMontoConvertidoPesos(gastoActualizado.getMontoConvertidoPesos());
        gasto.setVendedor(gastoActualizado.getVendedor());
        gasto.setObservacion(gastoActualizado.getObservacion());

        return gastoNegocioRepository.save(gasto);
    }

    @Override
    public void eliminarGasto(Long id) {
        GastoNegocio gasto = buscarPorId(id);
        gastoNegocioRepository.delete(gasto);
    }
}
