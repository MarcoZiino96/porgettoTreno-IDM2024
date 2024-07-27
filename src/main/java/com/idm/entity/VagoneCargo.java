package com.idm.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.idm.abstractClasses.AbstractVagone;

@Entity
@Table(name = "vagoneCargo")
public class VagoneCargo extends AbstractVagone{
	
	private double capacitaMassima;

	

	public VagoneCargo() {
		super();
	}

	public double getCapacitaMassima() {
		return capacitaMassima;
	}

	public void setCapacitaMassima(double capacitaMassima) {
		this.capacitaMassima = capacitaMassima;
	}

	
	
	

}
