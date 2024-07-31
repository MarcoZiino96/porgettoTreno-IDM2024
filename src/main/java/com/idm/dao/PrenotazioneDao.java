package com.idm.dao;

import com.idm.entity.Prenotazione;


public interface PrenotazioneDao {

   public Prenotazione add(Prenotazione vp);
	
	public void update(Prenotazione vp);

	public Prenotazione find(Integer id);
	
	public void delete(int id);
}
