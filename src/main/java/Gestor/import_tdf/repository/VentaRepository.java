package Gestor.import_tdf.repository;

import Gestor.import_tdf.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Vendedor, Long> {
}
