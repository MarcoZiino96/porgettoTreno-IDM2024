package com.idm.test1;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;
import com.idm.dao.TrenoDao;
import com.idm.dao.UtenteDao;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.entity.Prenotazione;
import com.idm.entity.Treno;
import com.idm.entity.Utente;
import com.idm.entity.VagonePasseggeri;
import com.idm.service.PrenotazioneService;
public class TestService {



	public static void main(String[] args) {
		//findUtente(1);
		//		Utente utente = testCreaUtente("Lollo", "My", "lollomy@gmail.com", LocalDate.parse("1980-01-01"), "aaaaaaa", "lollomy98");
		//		updateUtente( utente, 2);
		//testFindUtenti();
		testCreaPrenotazioneConCoordinate();


	}



	public static Utente testCreaUtente(String name, String cognome, String email, LocalDate dataNascita, String password, String username) {


		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean(UtenteDao.class);

		Utente utente = new Utente();
		utente.setCognome(cognome);
		utente.setNome(name); 
		utente.setEmail(email);
		utente.setDataNascita(dataNascita); 
		utente.setPassword(password);
		utente.setUsername(username);

		utente = dao.create(utente);
		System.out.println("Creato Utente: " + utente);
		return utente;
	}


	public static Utente findUtente(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean(UtenteDao.class); 
		Utente u = dao.find(id);
		System.out.println("Trovato Utente: " + u);
		return u;
	}

	public static Utente updateUtente(Utente vp, int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean(UtenteDao.class);
		Utente utente = findUtente(id);
		utente.setCognome(utente.getCognome());
		utente.setDataNascita(utente.getDataNascita());
		utente.setEmail(utente.getEmail());
		utente.setNome(utente.getNome());
		utente.setUsername(utente.getUsername());
		utente.setPassword(utente.getPassword());

		utente = dao.update(utente);
		System.out.println("Aggiornato Utente: " + utente);
		return utente;
	}

	public static void testFindUtenti() {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean(UtenteDao.class); 	
		List<Utente> u = dao.retrive();
		System.out.println("Utenti trovati: " + u);
	}

	public static void testCreaPrenotazioneConCoordinate() {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		PrenotazioneService prenotazioneService = factory.getBean(PrenotazioneService.class);
		UtenteDao utenteDao = factory.getBean(UtenteDao.class);
		TrenoDao trenoDao = factory.getBean(TrenoDao.class);

		Utente utente = new Utente();
		utente.setNome("Lorenzo");
		utente.setCognome("Rossi");
		utente.setEmail("lorenzo.rossi@gmail.com");
		utente.setDataNascita(LocalDate.parse("1980-01-01"));
		utente.setPassword("password");
		utente.setUsername("LorenzoRossi");

		utente = utenteDao.create(utente);

		Treno treno = new Treno();
		treno.setSigla("HPPPPRH");
		treno.setFoto(null);
		treno.setLunghezza(20.0);
		treno.setPeso(100.0);
		treno.setPrezzo(1000.0);
		trenoDao.create(treno);

		String dataPartenza = "2024-08-15"; 

		Prenotazione prenotazione = prenotazioneService.creaPrenotazioneConCoordinate(utente, treno, "A1-23", dataPartenza);

		System.out.println("Prenotazione creata: " + prenotazione);
	}



}
