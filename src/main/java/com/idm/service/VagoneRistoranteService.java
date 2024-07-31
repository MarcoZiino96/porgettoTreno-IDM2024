package com.idm.service;

<<<<<<< HEAD
import org.springframework.beans.factory.BeanFactory;
=======

>>>>>>> 905c8e72d15a9b3b1a5ac3d640bbb4f59d5759d7
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.idm.config.Beans;
import com.idm.dao.VagoneRistoranteDao;
import com.idm.entity.VagoneRistorante;

public class VagoneRistoranteService {
	
	@Autowired
<<<<<<< HEAD
	private VagoneRistoranteDao vagoneRistoranteDao;
=======
	VagoneRistoranteDao vagoneRistoranteDao;
>>>>>>> 905c8e72d15a9b3b1a5ac3d640bbb4f59d5759d7
	
	public VagoneRistorante create(VagoneRistorante vagoneRistorante) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        vagoneRistoranteDao = context.getBean(VagoneRistoranteDao.class);
		
		VagoneRistorante vagoneRistoranteNew = new VagoneRistorante();
		
		vagoneRistoranteNew.setLunghezza(vagoneRistorante.getLunghezza());
		vagoneRistoranteNew.setPeso(vagoneRistorante.getPeso());
		vagoneRistoranteNew.setPrezzo(vagoneRistorante.getPrezzo());
		vagoneRistoranteNew.setNumeroTavoli(vagoneRistorante.getNumeroTavoli());
		
		VagoneRistorante vr = vagoneRistoranteDao.add(vagoneRistorante);
		return vr;
	}
	
	public VagoneRistorante findVagoneRistorante(int id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        vagoneRistoranteDao = context.getBean(VagoneRistoranteDao.class);
		
		return vagoneRistoranteDao.find(id);
	}
	
	
	public VagoneRistorante updateVagoneRistorante(VagoneRistorante vagoneRistorante, int id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        vagoneRistoranteDao = context.getBean(VagoneRistoranteDao.class);
		
		VagoneRistorante OldVagoneRistorante = findVagoneRistorante(id);

		OldVagoneRistorante.setLunghezza(vagoneRistorante.getLunghezza());
		OldVagoneRistorante.setPeso(vagoneRistorante.getPeso());
		OldVagoneRistorante.setPrezzo(vagoneRistorante.getPrezzo());
		OldVagoneRistorante.setNumeroTavoli(vagoneRistorante.getNumeroTavoli());
		  
		  vagoneRistoranteDao.update(OldVagoneRistorante);
		  return(OldVagoneRistorante);
	}
	
	public void deleteVagoneRistorante(int id){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        vagoneRistoranteDao = context.getBean(VagoneRistoranteDao.class);
		 vagoneRistoranteDao.delete(id);
	}
	

}