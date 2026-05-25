package Gestor.import_tdf.repository;

import Gestor.import_tdf.entity.GastoNegocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoNegocioRepository extends JpaRepository<GastoNegocio, Long> {
}
