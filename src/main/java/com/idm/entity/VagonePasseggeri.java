package com.idm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.idm.abstractClasses.AbstractVagone;


@Entity
@Table(name = "vagonePasseggeri")
public class VagonePasseggeri extends AbstractVagone {
<<<<<<< HEAD
	
	
=======
	@Column
>>>>>>> 4602fa7872897855bc7399fa32ead9653d77c89e
	private int numeroPosti;
	
	

	public VagonePasseggeri() {
		super();
	}
	
	

	public VagonePasseggeri(int id, float lunghezza, float peso, double prezzo, Treno treno) {
		super(id, lunghezza, peso, prezzo, treno);
	}



	@Override
	public String toString() {
		return "VagonePasseggeri  [numeroPosti=" + numeroPosti + "]"+
	             super.toString();
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
	
	

}
