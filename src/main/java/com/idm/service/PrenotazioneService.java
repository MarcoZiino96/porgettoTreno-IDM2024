package com.idm.service;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.idm.config.Beans;
import com.idm.dao.PrenotazioneDao;
import com.idm.entity.Prenotazione;
import com.idm.entity.Treno;
import com.idm.entity.Utente;


@Component
public class PrenotazioneService {

	@Autowired
	PrenotazioneDao prenotazioneDao;


	public  Prenotazione creaPrenotazione( Prenotazione pr) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
		prenotazioneDao = context.getBean(PrenotazioneDao.class);
		Prenotazione p = new Prenotazione();
		p.setDataAttivazione(pr.getDataAttivazione());
		p.setDataPartenza(pr.getDataPartenza());
		p.setUtente(pr.getUtente());
		p.setTreno(pr.getTreno());
		p.setCoordinatePosto(pr.getCoordinatePosto());
		prenotazioneDao.add(p);

		return p;

	}

	public  Prenotazione findPrenotazione(int id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
		prenotazioneDao = context.getBean(PrenotazioneDao.class);
		Prenotazione p = prenotazioneDao.find(id);
		System.out.println(p);
		return p;
	}

	public  Prenotazione updatePrenotazione(Prenotazione p, int id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
		Prenotazione pOld = findPrenotazione(id);

		if (pOld != null) {
			pOld.setDataAttivazione(p.getDataAttivazione());
			pOld.setDataPartenza(p.getDataPartenza());
			pOld.setUtente(p.getUtente());
			pOld.setTreno(p.getTreno());
			pOld.setCoordinatePosto(p.getCoordinatePosto());
			prenotazioneDao.update(pOld);
		}
		return pOld;
	}

	public  void deletePrenotazione(int id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
		prenotazioneDao = context.getBean(PrenotazioneDao.class);
		prenotazioneDao.delete(id);	
	}



	//	Creazione una nuova prenotazione 
	public Prenotazione creaPrenotazioneConCoordinate(Utente utente, Treno treno, String coordinatePosto,String dataPartenza) {


		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setUtente(utente);
		prenotazione.setTreno(treno);
		prenotazione.setCoordinatePosto(coordinatePosto);
		prenotazione.setDataAttivazione(LocalDate.now());
		prenotazione.setDataPartenza(LocalDate.parse(dataPartenza));
		return prenotazioneDao.add(prenotazione);


	}



	//METODO CHE AGGIORNA LE CORDINATE PER UNA PRENOTAZIONE ESISTENTE DA VALUTARE SE METTERE O NO
	public void aggiornaCoordinatePosto(int id, String coordinatePosto) {
		Prenotazione p = findPrenotazione(id);
		if (p != null) {
			p.setCoordinatePosto(coordinatePosto);
			prenotazioneDao.update(p);
		}

	}
}