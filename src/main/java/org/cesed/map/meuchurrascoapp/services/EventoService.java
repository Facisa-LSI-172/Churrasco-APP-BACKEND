package org.cesed.map.meuchurrascoapp.services;

import java.util.List;

import javax.ws.rs.core.Response;

import org.cesed.map.meuchurrascoapp.dao.ContribuicaoDao;
import org.cesed.map.meuchurrascoapp.dao.EventoDao;
import org.cesed.map.meuchurrascoapp.dao.UsuarioDao;
import org.cesed.map.meuchurrascoapp.entities.Contribuicao;
import org.cesed.map.meuchurrascoapp.entities.Evento;
import org.cesed.map.meuchurrascoapp.entities.Usuario;

import com.google.gson.Gson;

public class EventoService {

	private EventoDao eventoDao = new EventoDao();
	private UsuarioDao usuarioDao = new UsuarioDao();
	private EmailService emailService = new EmailService();

	private ContribuicaoService contribuicaoService = new ContribuicaoService();

	public Evento cadastrarEvento(Evento evento) {
		return eventoDao.save(evento);
	}

	public String listarTodos() {
		List<Evento> lista = eventoDao.findAll();
		String json = new Gson().toJson(lista);
		return json;
	}

	public Evento getEventoPorId(Integer id) {
		return eventoDao.findById(id);
	}

	public Evento atualizarEvento(Evento evento) {
		if (evento.getListaParticipantes() != null) {
			contribuicaoService.atribuirContribuicaoAUsuario(evento);
		}
		Evento e = eventoDao.update(evento);
		
		e.setListaParticipantes(evento.getListaParticipantes());		
		
		if (e.getListaParticipantes() != null) {
			emailService.enviarEmail(e.getListaParticipantes(), e);
		}
		return e;
	}

	public void excluirEvento(Evento Evento) {
		eventoDao.remove(Evento);
	}

	public List<Usuario> buscarParticipantesDoEvento(Integer idEvento) {
		return eventoDao.buscarParticipantesPorEvento(idEvento);
	}

	public Evento adicionarParticipanteNoEvento(Evento evento) {
		return eventoDao.adicionarParticipanteNoEvento(evento);
	}

	public List<Evento> getEventosPorOrganizador(Integer idOrganizador) {
		List<Evento> lista = eventoDao.findEventoByOrganizador(idOrganizador);
		lista = buscarUsuariosComContribuicaoPorEvento(lista);
		return lista;
	}

	public Evento findById(Integer id) {
		return eventoDao.findById(id);
	}

	public List<Evento> getEventosPorParticipante(Integer idParticipante) {
		List<Evento> lista = eventoDao.findEventosByParticipante(idParticipante);
		lista = buscarUsuariosComContribuicaoPorEvento(lista);
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
	
	public List<Evento> buscarUsuariosComContribuicaoPorEvento(List<Evento> lista){
		for(Evento e: lista){
			for(Usuario u: e.getListaParticipantes()){
				List<Contribuicao> cList = new ContribuicaoDao()
						.buscarContribuicaoPorUsuarioEEvento(u.getId(), e.getId());
				u.setListaContribuicoes(cList);
			}
		}
		return lista; 
	}
}
