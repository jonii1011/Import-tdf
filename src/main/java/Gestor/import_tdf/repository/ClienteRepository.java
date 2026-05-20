package Gestor.import_tdf.repository;

import Gestor.import_tdf.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
