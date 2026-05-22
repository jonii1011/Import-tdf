package Gestor.import_tdf.repository;

import Gestor.import_tdf.entity.PagoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoVentaRepository extends JpaRepository<PagoVenta, Long> {
}
