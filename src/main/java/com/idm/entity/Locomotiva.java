package com.idm.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.idm.abstractClasses.AbstractVagone;

@Entity
@Table(name = "locomotiva")
public class Locomotiva extends AbstractVagone {
	
	private String potenza; //potenza
	

	public Locomotiva() {
		super();
	}

	public String getPotenza() {
		return potenza;
	}

	public void setPotenza(String potenza) {
		this.potenza = potenza;
	}

	
}
