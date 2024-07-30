package com.idm.dao;

import com.idm.entity.Prenotazione;
import com.idm.entity.Voto;

public interface VotoDao {
	
public Voto add(Voto p);
	
	public void update(Voto p);

	public Voto find(Integer id);
	
	public void delete(int id);
}
