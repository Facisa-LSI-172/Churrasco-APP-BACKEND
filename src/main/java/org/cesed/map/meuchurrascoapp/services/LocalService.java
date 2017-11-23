package org.cesed.map.meuchurrascoapp.services;

import java.util.List;

import org.cesed.map.meuchurrascoapp.dao.LocalDao;
import org.cesed.map.meuchurrascoapp.entities.Evento;
import org.cesed.map.meuchurrascoapp.entities.Local;

public class LocalService {

	private LocalDao localDao = new LocalDao();
	
	public Local cadastrarLocal(Local local){
		return (Local) localDao.save(local);
	}
	
	public List<Evento> listarTodos(){
		return localDao.findAll();
	}
	
	public Local getLocalPorId(Integer id){
		return (Local) localDao.findById(id);
	}
	
	public Local atualizarLocal(Local local){
		return (Local) localDao.update(local);
	}
	
	public void excluirLocal(Local local){
		localDao.remove(local);
	}
	
}
