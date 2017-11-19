package org.cesed.map.meuchurrascoapp.dao;

import javax.persistence.Query;

import org.cesed.map.meuchurrascoapp.base.GenericDao;
import org.cesed.map.meuchurrascoapp.entities.Evento;
import org.cesed.map.meuchurrascoapp.entities.Usuario;

public class UsuarioDao extends GenericDao<Usuario, Integer> {

	public Usuario findByEmail(String email) {
		try{
			String sql = "SELECT u from Usuario u where u.email = :email";
			Query query = getEntityManager().createQuery(sql);
			query.setParameter("email", email);
			Usuario usuario = (Usuario) query.getSingleResult();
			return usuario;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public boolean getStatusConfirmadoNoEvento(Evento evento, Usuario usuario){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT confirmado from usuario_evento where id_evento = :idEvento ");
		sql.append("AND id_usuario = :idUsuario ");
		Query query = getEntityManager().createNativeQuery(sql.toString());
		query.setParameter("idEvento", evento.getId());
		query.setParameter("idUsuario", usuario.getId());
		boolean result = (boolean) query.getSingleResult();
		return result; 
	}

}
