package com.idm.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;
import com.idm.dao.PrenotazioneDao;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.entity.Prenotazione;
import com.idm.entity.VagonePasseggeri;

public class PrenotazioneService {

public  VagonePasseggeri creaVagonePasseggeri( float lunghezza,float peso,double prezzo, int numeroPosti) {
		
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		VagonePasseggeri vp = new VagonePasseggeri();
		vp.setNumeroPosti(numeroPosti);
		vp.setPrezzo(prezzo);
		vp.setLunghezza(lunghezza);
		vp.setPeso(peso);
		dao.add(vp);

		return vp;

	}

	public  Prenotazione findPrenotazione(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		PrenotazioneDao dao = factory.getBean("prenotazione", PrenotazioneDao.class);
		Prenotazione p = dao.find(id);
	System.out.println(p);
		return p;
	}
	
	public  Prenotazione updateVagonePasseggeri(Prenotazione p, int id) {
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
	
	public  void deleteVagonePasseggeri(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		dao.delete(id);	
	}
    
}
