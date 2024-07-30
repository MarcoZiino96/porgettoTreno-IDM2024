package com.idm.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;

import com.idm.dao.VagoneRistoranteDao;
import com.idm.entity.VagoneRistorante;

public class VagoneRistoranteService {
	
	private VagoneRistoranteDao vagoneRistoranteDao;
	
	public VagoneRistorante create(float lunghezza, float peso, double prezzo, int numeroTavoli) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagoneRistoranteDao dao = factory.getBean("VagoneCargoDao",VagoneRistoranteDao.class);
		
		VagoneRistorante vagoneRistorante = new VagoneRistorante();
		
		vagoneRistorante.setLunghezza(lunghezza);
		vagoneRistorante.setPeso(peso);
		vagoneRistorante.setPrezzo(prezzo);
		vagoneRistorante.setNumeroTavoli(numeroTavoli);
		
		VagoneRistorante vr = dao.add(vagoneRistorante);
		return vr;
	}
	
	public static VagoneRistorante findVagoneRistorante(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagoneRistoranteDao dao = factory.getBean("VagoneRistoranteDao",VagoneRistoranteDao.class);
		System.out.println(dao.find(id));
		return dao.find(id);
	}
	
	
	public static VagoneRistorante updateVagoneRistorante(VagoneRistorante vagoneRistorante, int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagoneRistoranteDao dao = factory.getBean("VagoneRistoranteoDao",VagoneRistoranteDao.class);
		
		VagoneRistorante OldVagoneRistorante = findVagoneRistorante(id);

		OldVagoneRistorante.setLunghezza(vagoneRistorante.getLunghezza());
		OldVagoneRistorante.setPeso(vagoneRistorante.getPeso());
		OldVagoneRistorante.setPrezzo(vagoneRistorante.getPrezzo());
		OldVagoneRistorante.setNumeroTavoli(vagoneRistorante.getNumeroTavoli());
		  
		  dao.update(OldVagoneRistorante);
		  return(OldVagoneRistorante);
	}
	
	public static void deleteVagoneRistorante(int id){
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagoneRistoranteDao dao = factory.getBean("VagoneRistoranteDao",VagoneRistoranteDao.class);
		 dao.delete(id);
	}
	

}