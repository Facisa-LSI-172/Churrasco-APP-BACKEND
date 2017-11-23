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

import org.cesed.map.meuchurrascoapp.entities.Evento;
import org.cesed.map.meuchurrascoapp.entities.Usuario;
import org.cesed.map.meuchurrascoapp.services.EventoService;

@Path("evento")
public class EventoResource {

	private EventoService eventoService = new EventoService();

	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		String json = eventoService.listarTodos();

		return Response.ok(json).build();
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEvento(@PathParam("id") Integer id) {
		Evento evento = eventoService.findById(id);
		return Response.status(200).entity(evento).build();
	}

	@GET
	@Path("/{id}/participantes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getParticipantesDoEvento(@PathParam("id") Integer idEvento) {
		return eventoService.buscarParticipantesDoEvento(idEvento);
	}

	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Evento cadastrarEvento(Evento evento) {
		return eventoService.cadastrarEvento(evento);
	}

	@POST
	@Path("{idEvento}/confirmar/{idUsuario}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response confirmarPresenca(@PathParam("idEvento") Integer idEvento, @PathParam("idUsuario") Integer idUsuario) {
		return eventoService.confirmarPresenca(idUsuario, idEvento);
	}

	@POST
	@Path("/participantes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Evento cadastrarParticipantesNoEvento(Evento evento) {
		return eventoService.adicionarParticipanteNoEvento(evento);
	}

	@PUT
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Evento atualizarEvento(Evento evento) {
		return new EventoService().atualizarEvento(evento);
	}

	@DELETE
	@Path("/excluir/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluirEvento(@PathParam("id") String id, Evento evento) {
		new EventoService().excluirEvento(evento);
		return Response.status(200).build();
	}

	@GET
	@Path("/organizador/{idOrganizador}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Evento> getEventosPorOrganizador(@PathParam("idOrganizador") Integer idOrganizador) {
		return eventoService.getEventosPorOrganizador(idOrganizador);
	}

	@GET
	@Path("/participante/{idParticipante}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Evento> getEventosPorParticipante(@PathParam("idParticipante") Integer idParticipante) {
		return eventoService.getEventosPorParticipante(idParticipante);
	}
}
