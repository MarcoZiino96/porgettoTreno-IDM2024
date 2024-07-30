package com.idm.service;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.idm.config.Beans;
import com.idm.dao.LocomotivaDao;
import com.idm.entity.Locomotiva;


public class LocomotivaService {

	private LocomotivaDao locomotivaDao;




	public Locomotiva find(Integer id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		LocomotivaDao dao = factory.getBean("LocomotivaDao", LocomotivaDao.class);
		Locomotiva locomotivaFind = find(id);
		return locomotivaFind;
	}

	public Locomotiva createLocomotiva(String potenza,float lunghezza,float peso,double prezzo) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		LocomotivaDao locomotivaDao = factory.getBean("LocomotivaDao", LocomotivaDao.class);

		Locomotiva locomotiva1 = new Locomotiva();
		locomotiva1.setPotenza(potenza);
		locomotiva1.setLunghezza(lunghezza);
		locomotiva1.setPeso(peso);
		locomotiva1.setPrezzo(prezzo);

		locomotiva1 = locomotivaDao.create(locomotiva1);
		System.out.println(locomotiva1);
		return locomotiva1;
	}

	public Locomotiva update(Locomotiva locomotiva,int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		LocomotivaDao dao = factory.getBean("LocomotivaDao", LocomotivaDao.class); 

		Locomotiva locUpdate = find(id);

		locUpdate.setLunghezza(locUpdate.getLunghezza());
		locUpdate.setPeso(locUpdate.getPeso());
		locUpdate.setPotenza(locUpdate.getPotenza());
		locUpdate.setPrezzo(locUpdate.getPrezzo());
		dao.update(locUpdate);
		return locUpdate;
	}

	public void delete(Locomotiva locomotiva) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		LocomotivaDao dao = factory.getBean("LocomotivaDao", LocomotivaDao.class); 
		dao.delete(locomotiva);
	}

	public void delete(Integer id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		LocomotivaDao dao = factory.getBean("LocomotivaDao", LocomotivaDao.class); 
		dao.delete(id);
	}

	public List<Locomotiva> retrive() {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		LocomotivaDao dao = factory.getBean("LocomotivaDao", LocomotivaDao.class); 
		List<Locomotiva> u = dao.retrive();
		return u;

	}

}
