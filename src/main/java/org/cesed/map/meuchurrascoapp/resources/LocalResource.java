package org.cesed.map.meuchurrascoapp.resources;

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

import org.cesed.map.meuchurrascoapp.entities.Local;
import org.cesed.map.meuchurrascoapp.entities.Usuario;
import org.cesed.map.meuchurrascoapp.services.UsuarioService;

@Path("local")
public class LocalResource {

	@GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public Local getAll() {
        return new Local();
    }
    
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Local getLocal(@PathParam("id") String id) {
        return new Local();
    }
    
    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Local cadastrarLocal(Local local) {
    	return new UsuarioService().cadastrarLocal(local);
    }
    
    @PUT
    @Path("/atualizar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Local atualizarLocal(Local local){
    	return new UsuarioService().atualizarLocal(local);
    }
    
    @DELETE
    @Path("/excluir/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirLocal(@PathParam("id") String id, Local local){
    	new UsuarioService().excluirLocal(local);
    	return Response.status(200).build();
    }
	
}
