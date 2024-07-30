package com.idm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.idm.abstractClasses.AbstractVagone;

@Entity
@Table(name = "vagoneCargo")
public class VagoneCargo extends AbstractVagone{
	
	@Column (name = "capacita_massima")
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

	@Override
	public String toString() {
		return "VagoneCargo [capacitaMassima=" + capacitaMassima + "]";
	}

	
	
	

}
