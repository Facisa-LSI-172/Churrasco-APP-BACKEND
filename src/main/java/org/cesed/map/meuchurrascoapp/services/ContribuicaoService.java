package org.cesed.map.meuchurrascoapp.services;

import java.util.List;

import org.cesed.map.meuchurrascoapp.dao.ContribuicaoDao;
import org.cesed.map.meuchurrascoapp.entities.Contribuicao;

public class ContribuicaoService {

	private ContribuicaoDao contribuicaoDao;
	
	public Contribuicao cadastrarContribuicao(Contribuicao contribuicao){
		return contribuicaoDao.save(contribuicao);
	}
	
	public List<Contribuicao> listarTodos(){
		return contribuicaoDao.findAll();
	}
	
	public Contribuicao getEventoPorId(Integer id){
		return contribuicaoDao.findById(id);
	}
	
	public Contribuicao atualizarEvento(Contribuicao contribuicao){
		return contribuicaoDao.update(contribuicao);
	}
	
	public void excluirEvento(Contribuicao contribuicao){
		contribuicaoDao.remove(contribuicao);
	}
	
}
