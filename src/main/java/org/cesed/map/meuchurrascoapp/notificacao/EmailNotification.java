package org.cesed.map.meuchurrascoapp.notificacao;

import java.io.IOException;

import org.cesed.map.meuchurrascoapp.entities.Evento;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class EmailNotification {
	
	public void sendEmail(String toEmail, Evento evento) throws IOException{
		Email from = new Email("davi.leal737@gmail.com");
	    String subject = "Meu churrasco App - Convite";
	    Email to = new Email(toEmail);
	    
	    StringBuilder str = new StringBuilder();
	    
	    str.append("Você foi convidado para participar de um evento!");
	    
	    Content content = new Content("text/plain", str.toString());
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
	    
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      throw ex;
	    }
	}

}
