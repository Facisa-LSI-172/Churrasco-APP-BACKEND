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
	
<<<<<<< HEAD
	public Usuario atualizarUsuario(Usuario usuarioAntigo){
		return usuarioDao.update(usuarioAntigo);
=======
	public Usuario atualizarUsuario(Usuario novoUsuario){
		return usuarioDao.update(novoUsuario);
>>>>>>> develop
	}
	
	public void excluirUsuario(Usuario usuario){
		usuarioDao.remove(usuario);
	}
	
}
