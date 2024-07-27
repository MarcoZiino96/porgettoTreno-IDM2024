package com.idm.dao;

import com.idm.entity.VagonePasseggeri;

public interface VagonePasseggeriDao {
	

	public VagonePasseggeri add(VagonePasseggeri vp);
	
	public void update(VagonePasseggeri vp);

	public VagonePasseggeri find(Integer id);
	
	public void delete(int id);
}
