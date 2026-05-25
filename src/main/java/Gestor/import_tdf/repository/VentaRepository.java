package Gestor.import_tdf.repository;

import Gestor.import_tdf.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    Long countByFecha(LocalDate fecha);

    @Query("""
            SELECT COALESCE(SUM(v.totalVentaPesos), 0)
            FROM Venta v
            WHERE v.fecha = :fecha
            """)
    BigDecimal sumarIngresosDelDia(LocalDate fecha);

    @Query("""
            SELECT COALESCE(SUM(v.gananciaTotalPesos), 0)
            FROM Venta v
            WHERE v.fecha = :fecha
            """)
    BigDecimal sumarGananciasDelDia(LocalDate fecha);

    @Query("""
            SELECT COALESCE(SUM(SIZE(v.detalles)), 0)
            FROM Venta v
            WHERE v.fecha = :fecha
            """)
    Long contarProductosVendidosDelDia(LocalDate fecha);

    @Query("""
        SELECT COUNT(v)
        FROM Venta v
        WHERE v.fecha = :fecha
        AND v.vendedor.id = :vendedorId
        """)
    Long contarVentasDelDiaPorVendedor(LocalDate fecha, Long vendedorId);

    @Query("""
        SELECT COALESCE(SUM(v.totalVentaPesos), 0)
        FROM Venta v
        WHERE v.fecha = :fecha
        AND v.vendedor.id = :vendedorId
        """)
    BigDecimal sumarIngresosDelDiaPorVendedor(LocalDate fecha, Long vendedorId);

    @Query("""
        SELECT COALESCE(SUM(v.gananciaTotalPesos), 0)
        FROM Venta v
        WHERE v.fecha = :fecha
        AND v.vendedor.id = :vendedorId
        """)
    BigDecimal sumarGananciasDelDiaPorVendedor(LocalDate fecha, Long vendedorId);

    @Query("""
        SELECT COALESCE(SUM(SIZE(v.detalles)), 0)
        FROM Venta v
        WHERE v.fecha = :fecha
        AND v.vendedor.id = :vendedorId
        """)
    Long contarProductosVendidosDelDiaPorVendedor(LocalDate fecha, Long vendedorId);

    @Query("""
        SELECT COUNT(v)
        FROM Venta v
        WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin
        """)
    Long contarVentasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);

    @Query("""
        SELECT COALESCE(SUM(v.totalVentaPesos), 0)
        FROM Venta v
        WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin
        """)
    BigDecimal sumarIngresosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);

    @Query("""
        SELECT COALESCE(SUM(v.gananciaTotalPesos), 0)
        FROM Venta v
        WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin
        """)
    BigDecimal sumarGananciasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);

    @Query("""
        SELECT COALESCE(SUM(SIZE(v.detalles)), 0)
        FROM Venta v
        WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin
        """)
    Long contarProductosVendidosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);

    @Query("""
        SELECT COUNT(v)
        FROM Venta v
        WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin
        AND v.vendedor.id = :vendedorId
        """)
    Long contarVentasEntreFechasPorVendedor(
            LocalDate fechaInicio,
            LocalDate fechaFin,
            Long vendedorId
    );

    @Query("""
        SELECT COALESCE(SUM(v.totalVentaPesos), 0)
        FROM Venta v
        WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin
        AND v.vendedor.id = :vendedorId
        """)
    BigDecimal sumarIngresosEntreFechasPorVendedor(
            LocalDate fechaInicio,
            LocalDate fechaFin,
            Long vendedorId
    );

    @Query("""
        SELECT COALESCE(SUM(v.gananciaTotalPesos), 0)
        FROM Venta v
        WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin
        AND v.vendedor.id = :vendedorId
        """)
    BigDecimal sumarGananciasEntreFechasPorVendedor(
            LocalDate fechaInicio,
            LocalDate fechaFin,
            Long vendedorId
    );

    @Query("""
        SELECT COALESCE(SUM(SIZE(v.detalles)), 0)
        FROM Venta v
        WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin
        AND v.vendedor.id = :vendedorId
        """)
    Long contarProductosVendidosEntreFechasPorVendedor(
            LocalDate fechaInicio,
            LocalDate fechaFin,
            Long vendedorId
    );


}
