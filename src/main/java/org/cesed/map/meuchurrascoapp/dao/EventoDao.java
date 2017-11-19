package org.cesed.map.meuchurrascoapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.cesed.map.meuchurrascoapp.base.GenericDao;
import org.cesed.map.meuchurrascoapp.entities.Evento;
import org.cesed.map.meuchurrascoapp.entities.Usuario;

public class EventoDao extends GenericDao<Evento, Integer> {
	
	private UsuarioDao usuarioDao = new UsuarioDao();

	public List<Usuario> buscarParticipantesPorEvento(Integer idEvento) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from usuario u inner join evento_usuario ");
		sql.append(" on (u.id_usuario = evento_usuario.id_usuario)");
		Query query = getEntityManager().createNativeQuery(sql.toString());
		List<Usuario> lista = query.getResultList();
		return lista;
	}

	public Evento adicionarParticipanteNoEvento(Evento evento) {
		List<Usuario> listaSalvos = new ArrayList<>();
		for(Usuario u: evento.getListaParticipantes()){
			listaSalvos.add(usuarioDao.save(u));
		}
		evento.setListaParticipantes(listaSalvos);	
		update(evento);
		return evento;
	}

	public List<Evento> findEventoByOrganizador(Integer idOrganizador) {
		String sql = "SELECT e from Evento e where e.organizador.id = :idOrganizador";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("idOrganizador", idOrganizador);
		List<Evento> lista = query.getResultList();
		return lista;
	}

	public List<Evento> findEventosByParticipante(Integer idParticipante) {
		StringBuilder sql = new StringBuilder("select * from evento e where e.id_evento in ");
		sql.append("(select id_evento from usuario_evento where id_usuario = :idParticipante)");
		Query query = getEntityManager().createNativeQuery(sql.toString(), Evento.class);
		query.setParameter("idParticipante", idParticipante);
		List<Evento> lista = query.getResultList();
		return lista;
	}

	public void confirmarPresenca(Usuario usuario, Evento evento) {
		StringBuilder sql = new StringBuilder();
		sql.append("update usuario_evento SET confirmado=true ");
		sql.append("WHERE id_evento = :idEvento AND id_usuario = :idUsuario");
		getEntityManager().getTransaction().begin();
		Query query = getEntityManager().createNativeQuery(sql.toString());
		query.setParameter("idEvento", evento.getId());
		query.setParameter("idUsuario", usuario.getId());
		int result = query.executeUpdate();
		getEntityManager().getTransaction().commit();
	}

}
