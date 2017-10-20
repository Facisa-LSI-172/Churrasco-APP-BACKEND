package org.cesed.map.meuchurrascoapp.services;

import java.util.List;

import org.cesed.map.meuchurrascoapp.dao.UsuarioDao;
import org.cesed.map.meuchurrascoapp.entities.Usuario;

public class UsuarioService {

	private UsuarioDao usuarioDao = new UsuarioDao();
	
	public Usuario cadastrarUsuario(Usuario usuario){
		return usuarioDao.save(usuario);
	}
	
	public List<Usuario> listarTodos(){
		return usuarioDao.findAll();
	}
	
	public Usuario getUsuarioPorId(Integer id){
		return usuarioDao.findById(id);
	}
	
	public Usuario atualizarUsuario(Usuario usuario){
		return usuarioDao.update(usuario);
	}
	
	public void excluirUsuario(Usuario usuario){
		usuarioDao.remove(usuario);
	}
	
}
