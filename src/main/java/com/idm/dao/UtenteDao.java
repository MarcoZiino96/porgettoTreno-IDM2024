package com.idm.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.idm.entity.Utente;


@Transactional
public interface UtenteDao {
	public Utente find(Integer id);
	public Utente create(Utente ref);
	public Utente update(Utente ref);
	public void delete(Utente ref);
	public void delete(int id);
	public List<Utente> retrive();//mettere nel service
}
