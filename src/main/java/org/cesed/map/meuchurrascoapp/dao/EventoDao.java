package org.cesed.map.meuchurrascoapp.dao;

import java.util.List;

import javax.persistence.Query;

import org.cesed.map.meuchurrascoapp.base.GenericDao;
import org.cesed.map.meuchurrascoapp.entities.Evento;
import org.cesed.map.meuchurrascoapp.entities.Usuario;

public class EventoDao extends GenericDao<Evento, Integer> {

	public List<Usuario> buscarParticipantesPorEvento(Integer idEvento) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from usuario u inner join evento_usuario ");
		sql.append(" on (u.id_usuario = evento_usuario.id_usuario)");
		Query query = getEntityManager().createNativeQuery(sql.toString());
		List<Usuario> lista = query.getResultList();
		return lista;
	}

	public void adicionarParticipanteNoEvento(Integer idEvento, Integer idUsuario) {
		String sql = "insert into evento_usuario (id_usuario, id_evento) values (:id_usuario, :id_evento)";
		Query query = getEntityManager().createNativeQuery(sql);
		query.setParameter("id_usuario", idUsuario);
		query.setParameter("id_evento", idEvento);
		query.executeUpdate();
	}

}
