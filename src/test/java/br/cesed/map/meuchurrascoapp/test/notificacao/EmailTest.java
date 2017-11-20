package br.cesed.map.meuchurrascoapp.test.notificacao;

import org.cesed.map.meuchurrascoapp.entities.Evento;
import org.cesed.map.meuchurrascoapp.notificacao.EmailNotification;
import org.junit.Test;

public class EmailTest {
	
	@Test
	public void sendEmailTest(){
		
		String to = "davi.leal737@gmail.com";
		EmailNotification email = new EmailNotification();
		try{
			email.sendEmail(to, new Evento());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
