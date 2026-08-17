package com.snpp.agenda_pediatrica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snpp.agenda_pediatrica.crud.InfanteCrudRepository;
import com.snpp.agenda_pediatrica.entity.Infante;

@Repository
public class InfanteRepository {

	@Autowired
	private InfanteCrudRepository infanteCrud;
	
	public List<Infante> findAll(){
		return (List<Infante>) infanteCrud.findAll();
	}
	public Optional<Infante> findById(long id){
		return infanteCrud.findById(id);
}
	public Infante save(Infante infante) {
		return infanteCrud.save(infante);
	}
	
	public void deleteById(long id) {
		infanteCrud.deleteById(id);
	}
	public Infante update(Infante infante, Long id) {
		return null;
	}
}
