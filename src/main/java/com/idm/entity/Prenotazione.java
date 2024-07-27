package com.idm.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.idm.interfaces.Bean;

@Entity
public class Prenotazione implements Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "data_attivazione")
	private LocalDate dataAttivazione;
	
	@Column(name = "data_scadenza")
	private LocalDate dataScadenza;
	
	@ManyToOne
	@JoinColumn(name = "utente_fk")
	private Utente utente;
	
	@ManyToMany
	@JoinTable(
		name = "prenotazioni_treno",
		joinColumns = @JoinColumn(name = "prenotazione_fk"),
		inverseJoinColumns = @JoinColumn(name = "treno_fk")
			)
	private List<Treno> treno;
	
	public Prenotazione() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataAttivazione() {
		return dataAttivazione;
	}

	public void setDataAttivazione(LocalDate dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
	}

	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<Treno> getTreno() {
		return treno;
	}

	public void setTreno(List<Treno> treno) {
		this.treno = treno;
	}

}
