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
		return trenoDao.find(id);
	}

	public Treno createTreno(Treno treno) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
	    TrenoDao trenoDao = factory.getBean("TrenoDao", TrenoDao.class);
	    Utente utente = new Utente();
	    Treno treno1 = new Treno(utente, "TR789");
	    treno1 = trenoDao.create(treno1);
		return trenoDao.create(treno1);
	}

	public Treno update(Treno treno) {
		return trenoDao.update(treno);
	}

	public void delete(Treno treno) {
		trenoDao.delete(treno);
	}

	public void delete(Integer id) {
		trenoDao.delete(id);
	}

	public List<Treno> retrive() {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		TrenoDao dao = factory.getBean("TrenoDao", TrenoDao.class); 
		List<Treno> u = dao.retrive();
		return u;
		
	}

}
