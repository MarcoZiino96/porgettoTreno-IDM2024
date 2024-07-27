package com.idm.entity;
import java.util.List;
import javax.persistence.*;

import com.idm.abstractClasses.AbstractVagone;
import com.idm.interfaces.Bean;
import com.idm.interfaces.Vagone;


@Entity
@Table(name = "treno")
public class Treno implements Bean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "utente_fk")
	private Utente utente;
	
	private String sigla;
	
	@OneToMany(mappedBy = "treno")
	List<AbstractVagone> vagoni;
	
	
	
	
	public Treno() {
	}
	public Treno(Utente utente, String sigla) {
		
		this.utente = utente;
		this.sigla = sigla;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
