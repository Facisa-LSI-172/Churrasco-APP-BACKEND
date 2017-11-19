package org.cesed.map.meuchurrascoapp.notificacao;

import java.io.IOException;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class EmailNotification {
	
	public void sendEmail() throws IOException{
		Email from = new Email("davi.leal737@gmail.com");
	    String subject = "Sending with SendGrid is Fun";
	    Email to = new Email("davi.leal737@hotmail.com");
	    Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid(System.getenv("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"));
	    Request request = new Request();
	    
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } 
	    catch (IOException ex) {
	      throw ex;
	    }
	}

}
