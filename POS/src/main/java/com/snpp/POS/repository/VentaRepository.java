package com.snpp.POS.repository;

import java.math.BigDecimal;
import java.time.*;
import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

import com.snpp.POS.Entity.*;

public interface VentaRepository extends JpaRepository<Venta, Long> {

	    // --- Query methods derivados ---
	    List<Venta> findByTipo(TipoMovimiento tipo);

	    List<Venta> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);

	    List<Venta> findByEmpleadoIdAndTipo(Long empleadoId, TipoMovimiento tipo);

	    List<Venta> findByClienteId(Long clienteId);

	    List<Venta> findByTipoAndFechaBetweenOrderByFechaDesc(
	            TipoMovimiento tipo, LocalDateTime inicio, LocalDateTime fin);

	    // --- Reporte: total por tipo de movimiento en un rango de fechas ---
	    @Query("SELECT COALESCE(SUM(v.monto), 0) FROM Venta v " +
	           "WHERE v.tipo = :tipo AND v.fecha BETWEEN :inicio AND :fin")
	    BigDecimal totalPorTipoYFecha(@Param("tipo") TipoMovimiento tipo,
	                                  @Param("inicio") LocalDateTime inicio,
	                                  @Param("fin") LocalDateTime fin);

	    // --- Reporte: balance de caja (ventas + ingresos - egresos) ---
	    @Query("SELECT COALESCE(SUM(CASE WHEN v.tipo = 'EGRESO' THEN -v.monto ELSE v.monto END), 0) " +
	           "FROM Venta v WHERE v.fecha BETWEEN :inicio AND :fin")
	    BigDecimal calcularBalance(@Param("inicio") LocalDateTime inicio,
	                               @Param("fin") LocalDateTime fin);

	    // --- Reporte: productos más vendidos ---
	    @Query("SELECT v.producto.nombre, SUM(v.cantidad) AS totalVendido " +
	           "FROM Venta v WHERE v.tipo = 'VENTA' AND v.producto IS NOT NULL " +
	           "GROUP BY v.producto.nombre ORDER BY totalVendido DESC")
	    List<Object[]> productosMasVendidos();

	    // --- Reporte: total de ventas por empleado ---
	    @Query("SELECT v.empleado.nombre, v.empleado.apellido, COALESCE(SUM(v.monto), 0) " +
	           "FROM Venta v WHERE v.tipo = 'VENTA' " +
	           "GROUP BY v.empleado.id, v.empleado.nombre, v.empleado.apellido")
	    List<Object[]> totalVentasPorEmpleado();
	}

