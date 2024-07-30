package com.idm.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;
import com.idm.dao.UtenteDao;
import com.idm.entity.Treno;
import com.idm.entity.Utente;

public class UtenteService {

	//@Autowired
	private UtenteDao utente;


	public Utente find(Integer id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean("UtenteDao", UtenteDao.class); 
		return utente.find(id);
	}


	public Utente createUtente(String name, String cognome, String email, LocalDate dataNascita, String password, String username) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean("UtenteDao", UtenteDao.class);

		Utente utente = new Utente();
		utente.setCognome(cognome);
		utente.setNome(name); 
		utente.setEmail(email);
		utente.setDataNascita(dataNascita); 
		utente.setPassword(password);
		utente.setUsername(username);

		utente = dao.create(utente);
		System.out.println(utente);
		return dao.create(utente);
	}


	public Utente update(Utente ref) {

		return utente.update(ref);
	}


	public void delete(Utente ref) {
		utente.delete(ref);

	}


	public void delete(int id) {
		utente.delete(id);

	}
	
	public List<Utente> retrive(){
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean("UtenteDao", UtenteDao.class); 
		List<Utente> u = dao.retrive();
		return u;
	}



}
