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

import org.cesed.map.meuchurrascoapp.entities.Contribuicao;
import org.cesed.map.meuchurrascoapp.services.ContribuicaoService;

@Path("contribuicao")
public class ContribuicaoResource {

	@GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contribuicao> getAll() {
        return new ContribuicaoService().listarTodos();
    }
    
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contribuicao getContribuicao(@PathParam("id") String id) {
        return new ContribuicaoService().getContribuicaoPorId(Integer.valueOf(id));
    }
    
    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Contribuicao cadastrarContribuicao(Contribuicao contribuicao) {
    	return new ContribuicaoService().cadastrarContribuicao(contribuicao);
    }
    
    @PUT
    @Path("/atualizar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Contribuicao atualizarContribuicao(Contribuicao contribuicao){
    	return new ContribuicaoService().atualizarContribuicao(contribuicao);
    }
    
    @DELETE
    @Path("/excluir/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirContribuicao(@PathParam("id") String id, Contribuicao contribuicao){
    	new ContribuicaoService().excluirContribuicao(contribuicao);
    	return Response.status(200).build();
    }
	
}
