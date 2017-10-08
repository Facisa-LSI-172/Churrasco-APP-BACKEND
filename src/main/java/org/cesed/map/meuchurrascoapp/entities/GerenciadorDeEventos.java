package org.cesed.map.meuchurrascoapp.entities;

import org.cesed.map.meuchurrascoapp.factory.EventoFactory;
import org.cesed.map.meuchurrascoapp.services.EventoService;

public class GerenciadorDeEventos implements EventoFactory{

	private EventoService eventoService;
	
	@Override
	public void criarEvento(Evento evento) {
		eventoService.criarEvento(evento);
	}
	
}
