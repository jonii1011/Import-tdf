package Gestor.import_tdf.repository;

import Gestor.import_tdf.entity.Cotizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotizacionRepository extends JpaRepository<Cotizacion, Long> {
}
