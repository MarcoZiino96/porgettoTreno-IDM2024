package com.idm.test1;


import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.BeanFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.dao.impl.VagonePasseggeriImpl;
import com.idm.entity.VagonePasseggeri;
public class TestV {



	public static void main(String[] args) {

		//creaVagonePasseggeri(10, 50000, 250000, 78);
		//creaVagonePasseggeri(10, 50000, 250000, 55);
		
		//findVagonePasseggeri(1);
		
		//updateVagonePasseggeri(vp1, 1);
		
		//deleteVagonePasseggeri(3);
		
		//VagonePasseggeri vagonePasseggeri = new VagonePasseggeri(1000, 50000, 250000, 50);
		
		//updateVagonePasseggeri(vagonePasseggeri, 1);
	}


	public static VagonePasseggeri creaVagonePasseggeri( float lunghezza,float peso,double prezzo, int numeroPosti) {
		
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		VagonePasseggeri vp = new VagonePasseggeri();
		vp.setNumeroPosti(numeroPosti);
		vp.setPrezzo(prezzo);
		vp.setLunghezza(lunghezza);
		vp.setPeso(peso);
		dao.add(vp);

		return vp;

	}

	public static VagonePasseggeri findVagonePasseggeri(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		VagonePasseggeri vp = dao.find(id);
		System.out.println(vp);
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
	
	public static void deleteVagonePasseggeri(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		dao.delete(id);	
	}
}
