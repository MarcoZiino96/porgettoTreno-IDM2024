package com.idm.entity;

import javax.persistence.*;

import com.idm.abstractClasses.AbstractVagone;


@Entity
@Table(name = "vagoneRistorante")
public class VagoneRistorante extends AbstractVagone {
	
	
    
	@Column(name = "numero_tavoli")
	private int numeroTavoli;


	public VagoneRistorante() {
		super();
	}
	
	




	public int getNumeroTavoli() {
		return numeroTavoli;
	}

	public void setNumeroTavoli(int numeroTavoli) {
		this.numeroTavoli = numeroTavoli;
	}
	
	
	
}
