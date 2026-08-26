package com.snpp.POS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snpp.POS.Entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	    List<Producto> findByStockLessThan(Integer cantidad);
	    List<Producto> findByCategoriaIgnoreCase(String categoria);
	}

