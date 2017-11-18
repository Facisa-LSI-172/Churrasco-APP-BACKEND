package org.cesed.map.meuchurrascoapp.resources;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cesed.map.meuchurrascoapp.dto.UsuarioDto;
import org.cesed.map.meuchurrascoapp.entities.Usuario;
import org.cesed.map.meuchurrascoapp.services.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("usuario")
public class UsuarioResource {

	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getAll() {
		List<Usuario> lista = new UsuarioService().listarTodos();
		return lista;
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuario(@PathParam("id") String id) {
		Usuario usuario = new UsuarioService().getUsuarioPorId(Integer.valueOf(id));
		UsuarioDto dto = new UsuarioService().toUsuarioDto(usuario);
		return Response.status(200).entity(dto).build();
	}

	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarUsuario(Usuario usuario) {
		Usuario usuarioCreated = new UsuarioService().cadastrarUsuario(usuario);
		UsuarioDto dto = new UsuarioService().toUsuarioDto(usuarioCreated);
		return Response.status(200).entity(dto).build();
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(Usuario usuario){
		if (usuario.getEmail() == null || usuario.getPassword() == null) {
			return Response.status(401).build();
		}
		
		UsuarioDto dto = new UsuarioService().toUsuarioDto(usuario);
		
		dto.setToken(Jwts.builder().setSubject(usuario.getEmail())
				.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact());
		
		return Response.status(200).entity(dto).build();
	}

	@PUT
	@Path("/atualizar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarUsuario(Usuario usuario) {
		Usuario usuarioUpdated = new UsuarioService().atualizarUsuario(usuario);
		UsuarioDto dto = new UsuarioService().toUsuarioDto(usuarioUpdated);
		return Response.status(200).entity(dto).build();
	}

	@DELETE
	@Path("/excluir/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluirUsuario(@PathParam("id") String id, Usuario usuario) {
		new UsuarioService().excluirUsuario(usuario);
		return Response.status(200).build();
	}

}
