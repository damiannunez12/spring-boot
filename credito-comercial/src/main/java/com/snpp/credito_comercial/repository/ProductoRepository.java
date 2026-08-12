package com.snpp.credito_comercial.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snpp.credito_comercial.crud.ClienteCrudRepository;
import com.snpp.credito_comercial.crud.ProductoCrudRepository;
import com.snpp.credito_comercial.entity.Cliente;
import com.snpp.credito_comercial.entity.Producto;

@Repository
public class ProductoRepository {

    @Autowired
    private ProductoCrudRepository productoCrud;

    public List<Producto> listarTodos() {
        return (List<Producto>) productoCrud.findAll();
    }

    public Optional<Producto> buscarPorId(Long id) {
        return productoCrud.findById(id);
    }

    public Producto guardar(Producto producto) {
        return productoCrud.save(producto);
    }

    public void eliminar(Long id) {
        productoCrud.deleteById(id);
    }
}
