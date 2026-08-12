package com.snpp.credito_comercial.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snpp.credito_comercial.crud.PagoCrudRepository;
import com.snpp.credito_comercial.entity.Pago;

@Repository
	public class PagoRepository {

	    @Autowired
	    private PagoCrudRepository pagoCrud;

	    public List<Pago> listarTodos() {
	        return (List<Pago>) pagoCrud.findAll();
	    }

	    public Optional<Pago> buscarPorId(Long id) {
	        return pagoCrud.findById(id);
	    }

	    public Pago guardar(Pago pago) {
	        return pagoCrud.save(pago);
	    }

	    public void eliminar(Long id) {
	        pagoCrud.deleteById(id);
	    }
	}

