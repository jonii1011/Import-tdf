package Gestor.import_tdf.repository;

import Gestor.import_tdf.entity.ProductoCanje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCanjeRepository extends JpaRepository<ProductoCanje, Long> {
}
