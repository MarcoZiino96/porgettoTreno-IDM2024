package com.idm.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.idm.dao.TrenoDao;
import com.idm.entity.Treno;
import com.idm.entity.Utente;

public class TrenoDaoImpl extends DaoImpl implements TrenoDao {

	@PersistenceContext
	EntityManager manager;

	@Override
	public Treno find(Integer id) {
		Treno t = manager.find(Treno.class,id);
		return t;
	}

	@Transactional
	@Override
	public Treno create(Treno ref) {
		manager.persist(ref);
		return ref;
	}

	@Transactional
	@Override
	public Treno update(Treno ref) {
		manager.merge(ref);
		return ref;
	}
	@Transactional
	@Override
	public void delete(Treno ref) {
		manager.remove(ref);
	}

	@Override
	public List<Treno> retrive() {
		Query q = manager.createQuery("select x from Treno x",Treno.class);
		List<Treno> l = q.getResultList();
		return l;
	}

	@Transactional
	@Override
	public void delete(int id) {
		Treno c = this.find(id); 
		if (c!=null)
			manager.remove(c);
		
	}

	/*@Override
	public List<Treno> retriveBySigla(String sigla) {
		Query q = manager.createQuery("select x from Treno x where x.sigla=:searchSigla",Treno.class);
		q.setParameter("searchSigla",sigla);
		List<Treno> l = q.getResultList();
		return l;
	}*/

}
