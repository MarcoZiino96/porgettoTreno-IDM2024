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
		Utente utenteFind = dao.find(id);
		System.out.println(utenteFind);
		return utenteFind;
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
		return utente;
	}


	public Utente update(Utente ref,int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean("UtenteDao", UtenteDao.class); 
		Utente utente = find(id);
		
		utente.setCognome(utente.getCognome());
		utente.setDataNascita(utente.getDataNascita());
		utente.setEmail(utente.getEmail());
		utente.setNome(utente.getNome());
		utente.setUsername(utente.getUsername());
		utente.setPassword(utente.getPassword());
		
		dao.update(utente);
		
		return utente;
	}


	public void delete(Utente ref) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean("UtenteDao", UtenteDao.class); 
		utente.delete(ref);

	}


	public void delete(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean("UtenteDao", UtenteDao.class); 
		utente.delete(id);

	}
	
	public List<Utente> retrive(){
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean("UtenteDao", UtenteDao.class); 
		List<Utente> u = dao.retrive();
		System.out.println(u);
		return u;
	}



}
