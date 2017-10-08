package org.cesed.map.meuchurrascoapp.services;

import org.cesed.map.meuchurrascoapp.dao.ContribuicaoDao;
import org.cesed.map.meuchurrascoapp.entities.Contribuicao;

public class ContribuicaoService {

	private ContribuicaoDao contribuicaoDao;
	
	public void cadastrarContribuicaoParaUsuario(Contribuicao contribuicao){
		contribuicaoDao.save(contribuicao);
	}
	
}
