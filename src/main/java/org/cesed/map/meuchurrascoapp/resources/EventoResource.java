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

import org.cesed.map.meuchurrascoapp.entities.Evento;
import org.cesed.map.meuchurrascoapp.services.EventoService;

@Path("evento")
public class EventoResource {

	@GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public Evento getAll() {
        return new Evento();
    }
    
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Evento getEvento(@PathParam("id") String id) {
        return new Evento();
    }
    
    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Evento cadastrarUsuario(Evento evento) {
    	return new EventoService().cadastrarEvento(evento);
    }
    
    @PUT
    @Path("/atualizar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Evento atualizarUsuario(Evento evento){
    	return new EventoService().atualizarEvento(evento);
    }
    
    @DELETE
    @Path("/excluir/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirUsuario(@PathParam("id") String id, Evento evento){
    	new EventoService().excluirEvento(evento);
    	return Response.status(200).build();
    }
	
}
