package com.snpp.agenda_pediatrica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snpp.agenda_pediatrica.crud.VacunaCrudRepository;
import com.snpp.agenda_pediatrica.entity.Vacuna;


@Repository
public class VacunaRepository {

	@Autowired
	private VacunaCrudRepository vacunaCrud;
	
	public List<Vacuna> findAll(){
		return (List<Vacuna>) vacunaCrud.findAll();
	}
	public Optional<Vacuna> findById(long id){
		return vacunaCrud.findById(id);
    }
	public Vacuna save(Vacuna vacuna) {
		return vacunaCrud.save(vacuna);
	}
	
	  public List<Vacuna> saveAll(List<Vacuna> vacunas) {
	        return (List<Vacuna>) vacunaCrud.saveAll(vacunas);
	    }
	public void delete(long id) {
		vacunaCrud.deleteById(id);
	}
	public Vacuna update(Vacuna vacuna, Long id) {
		return null;
	}
}


