package com.idm.test1;

import java.beans.Beans;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.entity.VagonePasseggeri;
public class TestVagoni1 {

	; 

	public static void main(String[] args) {



	}


	public static VagonePasseggeri creaVagonePasseggeri( float lunghezza,float peso,double prezzo, int numeroPosti) {
		
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		VagonePasseggeri vp = new VagonePasseggeri();
		vp.setNumeroPosti(5);
		vp.setPrezzo(20000);
		vp.setLunghezza(10);
		vp.setPeso(25000);
		dao.add(vp);

		return vp;

	}

	public static VagonePasseggeri findVagonePasseggeri(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		VagonePasseggeri vp = dao.find(id);
		return vp;
	}
	
	public static VagonePasseggeri updateVagonePasseggeri(VagonePasseggeri vp, int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		VagonePasseggeri vpOld = findVagonePasseggeri(id);
		vpOld.setLunghezza(vp.getLunghezza());
		vpOld.setNumeroPosti(vp.getNumeroPosti());
		vpOld.setPeso(vp.getPeso());
		vpOld.setPrezzo(vp.getPrezzo());
		dao.update(vpOld);
		return vpOld;
	}
	
	

}
