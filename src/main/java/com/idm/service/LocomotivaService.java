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
		return locomotivaDao.find(id);
	}

	public Locomotiva createLocomotiva(Locomotiva locomotiva) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		LocomotivaDao locomotivaDao = factory.getBean("LocomotivaDao", LocomotivaDao.class);

		Locomotiva locomotiva1 = new Locomotiva();
		locomotiva1.setPotenza("5000 HP");
		locomotiva1.setLunghezza(20.5f);
		locomotiva1.setPeso(12000.0f);
		locomotiva1.setPrezzo(150000.0);
		locomotiva1 = locomotivaDao.create(locomotiva1);
		return locomotivaDao.create(locomotiva1);
	}

	public Locomotiva update(Locomotiva locomotiva) {
		return locomotivaDao.update(locomotiva);
	}

	public void delete(Locomotiva locomotiva) {
		locomotivaDao.delete(locomotiva);
	}

	public void delete(Integer id) {
		locomotivaDao.delete(id);
	}

	public List<Locomotiva> retrive() {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		LocomotivaDao dao = factory.getBean("LocomotivaDao", LocomotivaDao.class); 
		List<Locomotiva> u = dao.retrive();
		return u;
		
	}

}
