package com.snpp.POS.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;



	@Entity
	@Table(name = "empleados")
	@Data
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public class Empleado {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, length = 60)
	    private String nombre;

	    @Column(nullable = false, length = 60)
	    private String apellido;

	    @Column(nullable = false, length = 40)
	    private String cargo;

	    @Column(nullable = false, precision = 10, scale = 2)
	    private BigDecimal salario;

	    @Column(nullable = false)
	    private LocalDate fechaContratacion;
	    
	    

		public Empleado() {
			super();
		}

		
		
		public Empleado(Long id, String nombre, String apellido, String cargo, BigDecimal salario,
				LocalDate fechaContratacion) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.apellido = apellido;
			this.cargo = cargo;
			this.salario = salario;
			this.fechaContratacion = fechaContratacion;
		}



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

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getCargo() {
			return cargo;
		}

		public void setCargo(String cargo) {
			this.cargo = cargo;
		}

		public BigDecimal getSalario() {
			return salario;
		}

		public void setSalario(BigDecimal salario) {
			this.salario = salario;
		}

		public LocalDate getFechaContratacion() {
			return fechaContratacion;
		}

		public void setFechaContratacion(LocalDate fechaContratacion) {
			this.fechaContratacion = fechaContratacion;
		}
	    
	}

