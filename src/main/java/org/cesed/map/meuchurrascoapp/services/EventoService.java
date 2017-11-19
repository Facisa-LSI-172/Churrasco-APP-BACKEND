package org.cesed.map.meuchurrascoapp.services;

import java.util.List;

import javax.ws.rs.core.Response;

import org.cesed.map.meuchurrascoapp.dao.EventoDao;
import org.cesed.map.meuchurrascoapp.dao.UsuarioDao;
import org.cesed.map.meuchurrascoapp.entities.Evento;
import org.cesed.map.meuchurrascoapp.entities.Usuario;

import com.google.gson.Gson;

public class EventoService {
	
	private EventoDao eventoDao = new EventoDao();
	private UsuarioDao usuarioDao = new UsuarioDao();
	
	public Evento cadastrarEvento(Evento evento){
		return eventoDao.save(evento);
	}
	
	public String listarTodos(){
		List<Evento> lista = eventoDao.findAll();
		String json = new Gson().toJson(lista);
		return json;
	}
	
	public Evento getEventoPorId(Integer id){
		return eventoDao.findById(id);
	}
	
	public Evento atualizarEvento(Evento evento){
		UsuarioDao uDao = new UsuarioDao();
		if(evento.getListaParticipantes() != null){
			for(int i=0; i<evento.getListaParticipantes().size(); i++){
				Usuario usr = uDao.findByEmail(evento.getListaParticipantes().get(i).getEmail());
				if(usr != null){
					evento.getListaParticipantes().remove(i);
					evento.getListaParticipantes().add(i, usr);
				}
			}
		}
		return eventoDao.update(evento);
	}
	
	public void excluirEvento(Evento Evento){
		eventoDao.remove(Evento);
	}
	
	public List<Usuario> buscarParticipantesDoEvento(Integer idEvento){
		return eventoDao.buscarParticipantesPorEvento(idEvento);
	}
	
	public Evento adicionarParticipanteNoEvento(Evento evento){
		return eventoDao.adicionarParticipanteNoEvento(evento);
	}

	public List<Evento> getEventosPorOrganizador(Integer idOrganizador) {
		return eventoDao.findEventoByOrganizador(idOrganizador);
	}

	public Evento findById(Integer id) {
		return eventoDao.findById(id);
	}

	public List<Evento> getEventosPorParticipante(Integer idParticipante) {
		List<Evento> lista = eventoDao.findEventosByParticipante(idParticipante);
		for(Evento e: lista){
			for(Usuario u: e.getListaParticipantes()){
				boolean status = usuarioDao.getStatusConfirmadoNoEvento(e, u);
				u.setConfirmado(status);
			}
		}
		return lista;
	}
	
	public Response confirmarPresenca(Integer idUsuario, Integer idEvento){
		try{
			Evento evento = eventoDao.findById(idEvento);
			Usuario usuario = usuarioDao.findById(idUsuario);
			eventoDao.confirmarPresenca(usuario, evento);
			return Response.status(200).build();
		}
		catch(Exception e){
			return Response.status(500).build();
		}
		
	}
	
}
