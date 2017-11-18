package org.cesed.map.meuchurrascoapp.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import org.cesed.map.meuchurrascoapp.dao.UsuarioDao;
import org.cesed.map.meuchurrascoapp.dto.UsuarioDto;
import org.cesed.map.meuchurrascoapp.entities.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class UsuarioService {

	private UsuarioDao usuarioDao = new UsuarioDao();
	
	public Usuario cadastrarUsuario(Usuario usuario){
		return usuarioDao.save(usuario);
	}
	
	public Usuario getUsuarioPorEmail(String email){
		return usuarioDao.findByEmail(email);
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
	
	public Response login(Usuario usuario){
		if (usuario.getEmail() == null || usuario.getPassword() == null) {
			return Response.status(401).build();
		}
		Usuario u = new UsuarioService().getUsuarioPorEmail(usuario.getEmail());
		
		if(u != null){
			if(!u.getPassword().equals(usuario.getPassword())){
				return Response.status(401).build();
			}
		}
		else{
			return Response.status(401).build();
		}
		UsuarioDto dto = new UsuarioService().toUsuarioDto(u);
		dto.setToken(Jwts.builder().setSubject(usuario.getEmail())
				.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact());
		
		return Response.status(200).entity(dto).build();
	}
	
}
