package com.idm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.idm.abstractClasses.AbstractVagone;
import com.idm.config.Beans;
import com.idm.dao.AbstractVagoneDao;
import com.idm.dao.VagoneRistoranteDao;
import com.idm.entity.VagoneRistorante;

@Component
public class AbstractVagoneService {
	
	@Autowired
	private AbstractVagoneDao abtsractVagoneDao;

	public AbstractVagone create(AbstractVagone abstractVagone) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
		abtsractVagoneDao = context.getBean(AbstractVagoneDao.class);
        
		AbstractVagone va = abtsractVagoneDao.add(abstractVagone);
		return va;
	}
	
	
}
