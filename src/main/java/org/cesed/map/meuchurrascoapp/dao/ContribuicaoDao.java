package org.cesed.map.meuchurrascoapp.dao;

import java.util.List;

import javax.persistence.Query;

import org.cesed.map.meuchurrascoapp.base.GenericDao;
import org.cesed.map.meuchurrascoapp.entities.Contribuicao;

public class ContribuicaoDao extends GenericDao<Contribuicao, Integer>{

	public void salvarContribuicao(Integer idUsuario, Integer idContribuicao, Integer idEvento){
		StringBuilder sql = new StringBuilder("INSERT INTO usuario_contribuicao (id_usuario, id_contribuicao, id_evento) ");
		sql.append(" VALUES (:idUsuario, :idContribuicao, :idEvento)");
		
		Query query = getEntityManager().createNativeQuery(sql.toString());
		
		query.setParameter("idUsuario", idUsuario);
		query.setParameter("idContribuicao", idContribuicao);
		query.setParameter("idEvento", idEvento);
		
		getEntityManager().getTransaction().begin();
		query.executeUpdate();
		getEntityManager().getTransaction().commit();
	}
	
	public List<Contribuicao> buscarContribuicaoPorUsuarioEEvento(Integer idUsuario, Integer idEvento){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * from contribuicao where id_contribuicao in ( ");
		sql.append("SELECT id_contribuicao from usuario_contribuicao where id_usuario = :idUsuario and id_evento = :idEvento )");
		
		Query query = getEntityManager().createNativeQuery(sql.toString(), Contribuicao.class);
		
		query.setParameter("idUsuario", idUsuario);
		query.setParameter("idEvento", idEvento);
		
		List<Contribuicao> lista = query.getResultList();
		
		return lista;
	}
	
}
