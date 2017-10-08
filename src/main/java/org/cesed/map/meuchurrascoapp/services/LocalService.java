package org.cesed.map.meuchurrascoapp.services;

import org.cesed.map.meuchurrascoapp.dao.LocalDao;
import org.cesed.map.meuchurrascoapp.entities.Local;

public class LocalService {

	private LocalDao localDao = new LocalDao();
	
	public void cadastrarLocal(Local local){
		localDao.save(local);
	}
	
}
