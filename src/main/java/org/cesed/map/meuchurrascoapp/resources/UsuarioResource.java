package org.cesed.map.meuchurrascoapp.resources;

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

import org.cesed.map.meuchurrascoapp.entities.Usuario;
import org.cesed.map.meuchurrascoapp.services.UsuarioService;

@Path("usuario")
public class UsuarioResource {
	
	@GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getAll() {
        return new UsuarioService().listarTodos();
    }
    
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUsuario(@PathParam("id") String id) {
    	return new UsuarioService().getUsuarioPorId(Integer.valueOf(id));
    }
    
    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario cadastrarUsuario(Usuario usuario) {
    	return new UsuarioService().cadastrarUsuario(usuario);
    }
    
    @PUT
    @Path("/atualizar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Usuario atualizarUsuario(Usuario usuario){
    	return new UsuarioService().atualizarUsuario(usuario);
    }
    
    @DELETE
    @Path("/excluir/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirUsuario(@PathParam("id") String id, Usuario usuario){
    	new UsuarioService().excluirUsuario(usuario);
    	return Response.status(200).build();
    }
    
}
