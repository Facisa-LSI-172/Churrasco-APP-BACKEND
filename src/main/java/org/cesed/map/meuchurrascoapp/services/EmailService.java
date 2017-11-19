package org.cesed.map.meuchurrascoapp.services;

import java.util.List;

import org.cesed.map.meuchurrascoapp.entities.Evento;
import org.cesed.map.meuchurrascoapp.entities.Usuario;
import org.cesed.map.meuchurrascoapp.notificacao.EmailNotification;

public class EmailService {

	public void enviarEmail(List<Usuario> listaUsuarios, Evento evento){
		
		EmailNotification email = new EmailNotification();
		
		for(Usuario u: listaUsuarios){
			if(u.getEmail() != null){
				try{
					email.sendEmail(u.getEmail(), evento);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
