package com.idm.abstractClasses;

import javax.persistence.*;

import com.idm.entity.Treno;
import com.idm.interfaces.Cargo;
import com.idm.interfaces.Locomotiva;
import com.idm.interfaces.Passeggeri;
import com.idm.interfaces.Ristorante;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractVagone implements Locomotiva, Cargo, Ristorante, Passeggeri{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private float lunghezza;

	private float peso;

	private double prezzo;
	
	@ManyToOne
	@JoinColumn(name = "treno_fk")
	private Treno treno;

	
	public AbstractVagone() {
		
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
		return "Vagone [id=" + id + ", lunghezza=" + lunghezza + ", peso=" + peso + ", prezzo=" + prezzo
				+ ", treno=" + treno + "]";
	}
	
	
}
