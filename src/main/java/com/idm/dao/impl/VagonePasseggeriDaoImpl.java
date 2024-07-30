package com.idm.dao.impl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.entity.VagonePasseggeri;

<<<<<<< HEAD:src/main/java/com/idm/dao/impl/VagonePasseggeriImpl.java

public class VagonePasseggeriImpl extends DaoImpl implements VagonePasseggeriDao {
=======
public class VagonePasseggeriDaoImpl extends DaoImpl implements VagonePasseggeriDao {
>>>>>>> 4602fa7872897855bc7399fa32ead9653d77c89e:src/main/java/com/idm/dao/impl/VagonePasseggeriDaoImpl.java

	@PersistenceContext
	private EntityManager manager;


	@Override
	@Transactional
	public VagonePasseggeri add(VagonePasseggeri vp) {
		manager.persist(vp);
		return vp;
	}
	
	@Override
	@Transactional
	public void update(VagonePasseggeri vp) {
		manager.merge(vp);
	}

	@Override
	@Transactional
	public void delete(int id) {

		VagonePasseggeri vp = this.find(id);
		if(vp != null)
			manager.remove(vp);
	}

	@Override
	public VagonePasseggeri find(Integer id) {
		return manager.find(VagonePasseggeri.class, id );
	}
	
}


