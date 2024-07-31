package com.idm.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.idm.config.Beans;
import com.idm.dao.TrenoDao;
import com.idm.entity.Treno;
import com.idm.entity.Utente;



public class TrenoService {

	//@Autowired
	private TrenoDao trenoDao;

	public Treno find(Integer id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		TrenoDao dao = factory.getBean("TrenoDao", TrenoDao.class); 
		Treno trenoFind = dao.find(id);
		System.out.println(trenoFind);
		return trenoFind;
	}

	public Treno createTreno(Treno treno) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		TrenoDao trenoDao = factory.getBean("TrenoDao", TrenoDao.class);
		Treno treno1 = new Treno();
		treno1.setSigla(treno1.getSigla());
		treno1.setUtente(treno1.getUtente());
		treno1 = trenoDao.create(treno1);
		return treno1;
	}

	public Treno update(Treno treno,int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		TrenoDao trenoDao = factory.getBean("TrenoDao", TrenoDao.class);

		Treno treno1 = find(id);

		treno1.setSigla(treno1.getSigla());
		treno1.setUtente(treno1.getUtente());
		trenoDao.update(treno1);
		return treno1;
	}

	public void delete(Treno treno) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		TrenoDao trenoDao = factory.getBean("TrenoDao", TrenoDao.class);
		trenoDao.delete(treno);
	}

	public void delete(Integer id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		TrenoDao trenoDao = factory.getBean("TrenoDao", TrenoDao.class);
		trenoDao.delete(id);
	}

	public List<Treno> retrive() {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		TrenoDao dao = factory.getBean("TrenoDao", TrenoDao.class); 
		List<Treno> u = dao.retrive();
		System.out.println(u);
		return u;
	}
	
	public List<Treno> retriveWithOrder(String ordine, String direction) {
        BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
        TrenoDao dao = factory.getBean("TrenoDao", TrenoDao.class);
        List<Treno> u = dao.retriveWithOrder(ordine, direction);
        System.out.println(u);
		return u;
    }

}
