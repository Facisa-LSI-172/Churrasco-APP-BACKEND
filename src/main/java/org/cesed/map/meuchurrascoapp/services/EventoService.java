package org.cesed.map.meuchurrascoapp.services;

import org.cesed.map.meuchurrascoapp.dao.EventoDao;
import org.cesed.map.meuchurrascoapp.entities.Evento;

public class EventoService {

	private EventoDao eventoDao;
	
	/**
	 * Método responsável por enviar o evento para o DAO para persistência.
	 * @param evento
	 */
	public void criarEvento(Evento evento){
		eventoDao.save(evento);
	}
	
}
