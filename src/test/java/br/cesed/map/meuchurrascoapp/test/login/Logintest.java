package br.cesed.map.meuchurrascoapp.test.login;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.cesed.map.meuchurrascoapp.dao.UsuarioDao;
import org.cesed.map.meuchurrascoapp.entities.Usuario;
import org.cesed.map.meuchurrascoapp.services.UsuarioService;
import org.junit.Test;

import junit.framework.Assert;

public class Logintest {

	@Test
	public void loginTest() {
		Usuario usuario = new Usuario();
		UsuarioDao dao = new UsuarioDao();
		UsuarioService service = new UsuarioService();
		
		usuario.setEmail("email@email");
		usuario.setPassword("123");
		usuario.setNome("Davi");
		
		usuario = dao.save(usuario);
		
		Usuario u1 = new Usuario();
		u1.setEmail("email@email");	
		u1.setPassword("123");
		
		Response result = service.login(u1);
	
		Assert.assertEquals(200, result.getStatus());
		
		u1 = new Usuario();
		u1.setEmail("email@email");	
		u1.setPassword("12323456");
		
		result = service.login(u1);
		
		Assert.assertEquals(401, result.getStatus());
		
	}

}
