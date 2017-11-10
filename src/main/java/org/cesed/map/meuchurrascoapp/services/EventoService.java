package org.cesed.map.meuchurrascoapp.services;

import java.util.List;

import org.cesed.map.meuchurrascoapp.dao.EventoDao;
import org.cesed.map.meuchurrascoapp.dto.EventoUsuarioDTO;
import org.cesed.map.meuchurrascoapp.entities.Evento;
import org.cesed.map.meuchurrascoapp.entities.Usuario;

public class EventoService {
	
	private EventoDao eventoDao = new EventoDao();
	
	public Evento cadastrarEvento(Evento evento){
		return eventoDao.save(evento);
	}
	
	public List<Evento> listarTodos(){
		return eventoDao.findAll();
	}
	
	public Evento getEventoPorId(Integer id){
		return eventoDao.findById(id);
	}
	
	public Evento atualizarEvento(Evento Evento){
		return eventoDao.update(Evento);
	}
	
	public void excluirEvento(Evento Evento){
		eventoDao.remove(Evento);
	}
	
	public List<Usuario> buscarParticipantesDoEvento(Integer idEvento){
		return eventoDao.buscarParticipantesPorEvento(idEvento);
	}
	
	public void adicionarParticipanteNoEvento(EventoUsuarioDTO eventoUsuarioDTO){
		Integer idUsuario = eventoUsuarioDTO.getIdUsuario();
		Integer idEvento = eventoUsuarioDTO.getIdEvento();
		eventoDao.adicionarParticipanteNoEvento(idEvento, idUsuario);
	}
	
}
