package com.idm.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.idm.entity.Treno;

@Transactional
public interface TrenoDao {

	public Treno find(Integer id);
	public Treno create(Treno ref);
	public Treno update(Treno ref);
	public void delete(Treno ref);
	public void delete(int id);
	public List<Treno> retrive();
	
	//public List<Treno> retriveBySigla(String sigla);
}
