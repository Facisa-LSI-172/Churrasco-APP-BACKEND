package org.cesed.map.meuchurrascoapp.services;

import java.util.List;

import org.cesed.map.meuchurrascoapp.dao.ContribuicaoDao;
import org.cesed.map.meuchurrascoapp.dao.UsuarioDao;
import org.cesed.map.meuchurrascoapp.entities.Contribuicao;
import org.cesed.map.meuchurrascoapp.entities.Evento;
import org.cesed.map.meuchurrascoapp.entities.Usuario;

public class ContribuicaoService {

	private ContribuicaoDao contribuicaoDao = new ContribuicaoDao();
	private UsuarioDao usuarioDao = new UsuarioDao();

	public Contribuicao cadastrarContribuicao(Contribuicao contribuicao) {
		return contribuicaoDao.save(contribuicao);
	}

	public List<Contribuicao> listarTodos() {
		return contribuicaoDao.findAll();
	}

	public Contribuicao getContribuicaoPorId(Integer id) {
		return contribuicaoDao.findById(id);
	}

	public Contribuicao atualizarContribuicao(Contribuicao contribuicao) {
		return contribuicaoDao.update(contribuicao);
	}

	public void excluirContribuicao(Contribuicao contribuicao) {
		contribuicaoDao.remove(contribuicao);
	}

	public Evento atribuirContribuicaoAUsuario(Evento evento) {
		for (int i = 0; i < evento.getListaParticipantes().size(); i++) {
			
			Usuario usuario = usuarioDao.findByEmail(evento.getListaParticipantes().get(i).getEmail());
			
			if(usuario == null){
				usuario = usuarioDao.save(evento.getListaParticipantes().get(i));
			}
			
			for (Contribuicao c : evento.getListaParticipantes().get(i).getListaContribuicoes()) {
				Contribuicao cont = this.cadastrarContribuicao(c);
				contribuicaoDao.salvarContribuicao(usuario.getId(), cont.getId(), evento.getId());
			}
			evento.getListaParticipantes().remove(i);
			evento.getListaParticipantes().add(i, usuario);
		}
		return evento;
	}

}
