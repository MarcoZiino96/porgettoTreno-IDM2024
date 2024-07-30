package com.idm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.idm.abstractClasses.AbstractVagone;


@Entity
@Table(name = "vagonePasseggeri")
public class VagonePasseggeri extends AbstractVagone {
	@Column
	private int numeroPosti;
	
	

	public VagonePasseggeri() {
		super();
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
	

}
