package com.idm.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.idm.config.Beans;
import com.idm.dao.VotoDao;
import com.idm.entity.Voto;

public class VotoService {

public  Voto creaVoto( Voto voto) {
		
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VotoDao dao = factory.getBean("voto", VotoDao.class);
		Voto v = new Voto();
		v.setTreno(voto.getTreno());
		v.setUtente(voto.getUtente());
		v.setVoto(voto.getVoto());
		dao.add(v);

		return v;

	}

	public  Voto findVoto(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VotoDao dao = factory.getBean("voto", VotoDao.class);
		Voto p = dao.find(id);
	System.out.println(p);
		return p;
	}
	
	public  Voto updateVoto(Voto voto, int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VotoDao dao = factory.getBean("voto", VotoDao.class);
		Voto vOld = findVoto(id);
		vOld.setTreno(voto.getTreno());
		vOld.setUtente(voto.getUtente());
		vOld.setVoto(voto.getVoto());
		return vOld;
	}
	
	public  void deleteVoto(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VotoDao dao = factory.getBean("voto", VotoDao.class);
		dao.delete(id);	
	}
}
