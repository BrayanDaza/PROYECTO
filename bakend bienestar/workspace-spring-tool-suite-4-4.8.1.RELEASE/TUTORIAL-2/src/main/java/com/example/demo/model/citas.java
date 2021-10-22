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
@Table(name = "citas")
public class citas {
	
	
	
	@ManyToOne
	@JoinColumn
	private Estudiante estudiante;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idcita;
	


	@Column(name = "tipocita")
	private String tipocita;
    


	public Estudiante getEstudiante() {
		return estudiante;
	}



	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	public long getIdcita() {
		return idcita;
	}

	


	public void setIdcita(long idcita) {
		this.idcita = idcita;
	}



	public String getTipocita() {
		return tipocita;
	}



	public void setTipocita(String tipocita) {
		this.tipocita = tipocita;
	}
	
	
	
	

	

	
	
	
	
}