package Gestor.import_tdf.service;

import Gestor.import_tdf.entity.GastoNegocio;

import java.util.List;

public interface GastoNegocioService {
    List<GastoNegocio> listarGastos();

    GastoNegocio buscarPorId(Long id);

    GastoNegocio crearGasto(GastoNegocio gastoNegocio);

    GastoNegocio actualizarGasto(Long id, GastoNegocio gastoActualizado);

    void eliminarGasto(Long id);
}
