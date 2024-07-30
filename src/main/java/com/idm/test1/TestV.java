package com.idm.test1;


<<<<<<< HEAD
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
=======
import java.time.LocalDate;
import java.util.List;

>>>>>>> 22422b7e170019fd50518133ae4fb0fdd5425195
import org.springframework.beans.factory.BeanFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;
<<<<<<< HEAD
import com.idm.dao.VagonePasseggeriDao;
import com.idm.dao.impl.VagonePasseggeriImpl;
=======
import com.idm.dao.UtenteDao;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.entity.Utente;
>>>>>>> 22422b7e170019fd50518133ae4fb0fdd5425195
import com.idm.entity.VagonePasseggeri;
public class TestV {



	public static void main(String[] args) {
<<<<<<< HEAD

		creaVagonePasseggeri(10, 50000, 250000, 78);
		//creaVagonePasseggeri(10, 50000, 250000, 55);
		
		//findVagonePasseggeri(1);
		
		//updateVagonePasseggeri(vp1, 1);
		
		//deleteVagonePasseggeri(3);
		
		//VagonePasseggeri vagonePasseggeri = new VagonePasseggeri(1000, 50000, 250000, 50);
		
		//updateVagonePasseggeri(vagonePasseggeri, 1);
=======
		//findUtente(1);
//		Utente utente = testCreaUtente("Lollo", "My", "lollomy@gmail.com", LocalDate.parse("1980-01-01"), "aaaaaaa", "lollomy98");
//		updateUtente( utente, 2);
		testFindUtenti();


>>>>>>> 22422b7e170019fd50518133ae4fb0fdd5425195
	}


	public static Utente testCreaUtente(String name, String cognome, String email, LocalDate dataNascita, String password, String username) {


		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
<<<<<<< HEAD
		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		VagonePasseggeri vp = new VagonePasseggeri();
		vp.setNumeroPosti(numeroPosti);
		vp.setPrezzo(prezzo);
		vp.setLunghezza(lunghezza);
		vp.setPeso(peso);
		dao.add(vp);
=======
		UtenteDao dao = factory.getBean("UtenteDao", UtenteDao.class);
>>>>>>> 22422b7e170019fd50518133ae4fb0fdd5425195

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
<<<<<<< HEAD
		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		VagonePasseggeri vp = dao.find(id);
		System.out.println(vp);
		return vp;
=======
		UtenteDao dao = factory.getBean("UtenteDao", UtenteDao.class); 
		Utente u = dao.find(id);
		System.out.println("Trovato Utente: " + u);
		return u;
	}

	public static Utente updateUtente(Utente vp, int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean("UtenteDao", UtenteDao.class);
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
>>>>>>> 22422b7e170019fd50518133ae4fb0fdd5425195
	}
	
	public static void testFindUtenti() {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean("UtenteDao", UtenteDao.class); 	
		List<Utente> u = dao.retrive();
		System.out.println("Utenti trovati: " + u);
	}
<<<<<<< HEAD
	
	public static void deleteVagonePasseggeri(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		dao.delete(id);	
	}
=======



>>>>>>> 22422b7e170019fd50518133ae4fb0fdd5425195
}
