package com.idm.abstractClasses;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.idm.entity.Treno;
import com.idm.interfaces.Cargo;
import com.idm.interfaces.Locomotiva;
import com.idm.interfaces.Passeggeri;
import com.idm.interfaces.Ristorante;
import com.idm.interfaces.Vagone;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Component
public abstract class AbstractVagone implements Vagone{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private float lunghezza;
	@Column
	private float peso;
	@Column
	private double prezzo;
	
	@ManyToOne
	@JoinColumn(name = "treno_fk")
	private Treno treno;

	
	public AbstractVagone() {
		
	}
	
	public AbstractVagone( float lunghezza, float peso, double prezzo, Treno treno) {
		this.lunghezza = lunghezza;
		this.peso = peso;
		this.prezzo = prezzo;
		this.treno = treno;
	}
	
	public AbstractVagone( float lunghezza, float peso, double prezzo) {
		this.lunghezza = lunghezza;
		this.peso = peso;
		this.prezzo = prezzo;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setLunghezza(float lunghezza) {
		this.lunghezza = lunghezza;
	}


	public void setPeso(float peso) {
		this.peso = peso;
	}


	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}


	public float getPeso() {
		return peso;
	}


	public double getPrezzo() {
		return prezzo;
	}





	public float getLunghezza()
	{
		return this.lunghezza;
	}


	@Override
	public String toString() {
		return "AbstractVagone [id=" + id + ", lunghezza=" + lunghezza + ", peso=" + peso + ", prezzo=" + prezzo
				;
	}
	
}
