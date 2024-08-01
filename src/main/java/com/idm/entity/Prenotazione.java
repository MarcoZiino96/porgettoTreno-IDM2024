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


	@Column(name="coordinate_posto")
	private String coordinatePosto;	
	
	@Column(name="data_partenza")
	private LocalDate dataPartenza;

	@ManyToOne
	@JoinColumn(name = "utente_fk")
	private Utente utente;

	@ManyToOne
	@JoinColumn(name="treno_fk")
	private Treno treno;

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


	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Treno getTreno() {
		return treno;
	}

	public void setTreno(Treno treno) {
		this.treno = treno;
	}

	public String getCoordinatePosto() {
		return coordinatePosto;
	}

	public void setCoordinatePosto(String coordinatePosto) {
		this.coordinatePosto = coordinatePosto;
	}
	
	public LocalDate getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(LocalDate dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	@Override
	public String toString() {
		return "Prenotazione [id=" + id + ", dataAttivazione=" + dataAttivazione + ", coordinatePosto="
				+ coordinatePosto + ", dataPartenza=" + dataPartenza + ", utente=" + utente + ", treno=" + treno + "]";
	}
}
