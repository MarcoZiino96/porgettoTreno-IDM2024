package com.idm.dao.impl;

import java.util.List;

import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.entity.VagonePasseggeri;

public class VagonePasseggeriImpl extends DaoImpl implements VagonePasseggeriDao {

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


