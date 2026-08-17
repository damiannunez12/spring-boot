package com.snpp.agenda_pediatrica.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="vacunas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vacuna {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column (name= "id_vacuna")
	private Long id;
	private String nombre;
	private String descripcion;
	
	@Column (name= "fecha_estimada")
	private LocalDateTime fechaEstimada;
	
	@Column (name= "fecha_aplicacion")
	private LocalDateTime fechaAplicacion;
	
	@ManyToOne
	@JoinColumn (name= "id_infante")
	@JsonBackReference
	private Infante infante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaEstimada() {
		return fechaEstimada;
	}

	public void setFechaEstimada(LocalDateTime fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}

	public LocalDateTime getFechaAplicacion() {
		return fechaAplicacion;
	}

	public void setFechaAplicacion(LocalDateTime fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}

	public Infante getInfante() {
		return infante;
	}

	public void setInfante(Infante infante) {
		this.infante = infante;
	}
	
}
