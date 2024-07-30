package com.idm.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;
import com.idm.dao.PrenotazioneDao;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.entity.Prenotazione;
import com.idm.entity.VagonePasseggeri;

public class PrenotazioneService {

public  Prenotazione creaPrenotazione( Prenotazione pr) {
		
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		PrenotazioneDao dao = factory.getBean("prenotazione", PrenotazioneDao.class);
		Prenotazione p = new Prenotazione();
		p.setDataAttivazione(pr.getDataAttivazione());
		p.setDataScadenza(pr.getDataScadenza());
		p.setUtente(pr.getUtente());;
		p.setTreno(pr.getTreno());;
		dao.add(p);

		return p;

	}

	public  Prenotazione findPrenotazione(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		PrenotazioneDao dao = factory.getBean("prenotazione", PrenotazioneDao.class);
		Prenotazione p = dao.find(id);
	System.out.println(p);
		return p;
	}
	
	public  Prenotazione updatePrenotazione(Prenotazione p, int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		PrenotazioneDao dao = factory.getBean("prenotazione", PrenotazioneDao.class);
		Prenotazione pOld = findPrenotazione(id);
		pOld.setDataAttivazione(p.getDataAttivazione());;
		pOld.setDataScadenza(p.getDataScadenza());
		pOld.setUtente(p.getUtente());
		pOld.setTreno(p.getTreno());
		dao.update(pOld);
		return pOld;
	}
	
	public  void deletePrenotazione(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		PrenotazioneDao dao = factory.getBean("prenotazione", PrenotazioneDao.class);
		dao.delete(id);	
	}
    
}
