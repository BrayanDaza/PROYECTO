package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comedores")
public class Comedores {
	
	

	@ManyToOne
	@JoinColumn
	private Estudiante estudiante;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ide;
	
	
	@Column(name = "motivoe")
	private String motivoe;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "serviciotipo")
	private String serviciotipo;

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public long getIde() {
		return ide;
	}

	public void setIde(long ide) {
		this.ide = ide;
	}

	public String getMotivoe() {
		return motivoe;
	}

	public void setMotivoe(String motivoe) {
		this.motivoe = motivoe;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getServiciotipo() {
		return serviciotipo;
	}

	public void setServiciotipo(String serviciotipo) {
		this.serviciotipo = serviciotipo;
	}
	
	
	
	

}
