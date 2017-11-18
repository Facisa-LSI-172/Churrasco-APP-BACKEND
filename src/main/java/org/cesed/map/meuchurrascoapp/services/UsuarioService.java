package org.cesed.map.meuchurrascoapp.services;

import java.util.ArrayList;
import java.util.List;

import org.cesed.map.meuchurrascoapp.dao.UsuarioDao;
import org.cesed.map.meuchurrascoapp.dto.UsuarioDto;
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
	
	public Usuario atualizarUsuario(Usuario usuarioAntigo){
		return usuarioDao.update(usuarioAntigo);
	}
	
	public void excluirUsuario(Usuario usuario){
		usuarioDao.remove(usuario);
	}
	
	public UsuarioDto toUsuarioDto(Usuario usuario){
		UsuarioDto dto = new UsuarioDto();
		dto.setId(usuario.getId());
		dto.setNome(usuario.getNome());
		dto.setEmail(usuario.getEmail());
		return dto;
	}
	
	public List<UsuarioDto> toUsuarioDto(List<Usuario> usuarioList){
		List<UsuarioDto> listaDto = new ArrayList<>();
		for(Usuario usuario: usuarioList){
			UsuarioDto dto = new UsuarioDto();
			dto.setId(usuario.getId());
			dto.setEmail(usuario.getEmail());
			dto.setNome(usuario.getNome());
			listaDto.add(dto);
		}
		return listaDto;
	}
	
}
