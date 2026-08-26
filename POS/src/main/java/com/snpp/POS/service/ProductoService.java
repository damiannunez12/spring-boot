package com.snpp.POS.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.snpp.POS.Entity.Producto;
import com.snpp.POS.repository.ProductoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    

    public ProductoService(ProductoRepository productoRepository) {
		super();
		this.productoRepository = productoRepository;
	}

	public List<Producto> listar() {
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    public List<Producto> listarConStockBajo(Integer minimo) {
        return productoRepository.findByStockLessThan(minimo);
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizar(Long id, Producto datos) {
        Producto producto = obtenerPorId(id);
        producto.setNombre(datos.getNombre());
        producto.setDescripcion(datos.getDescripcion());
        producto.setPrecio(datos.getPrecio());
        producto.setStock(datos.getStock());
        producto.setCategoria(datos.getCategoria());
        return productoRepository.save(producto);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
