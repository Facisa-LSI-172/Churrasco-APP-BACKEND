package br.cesed.map.meuchurrascoapp.test.daos;

import org.cesed.map.meuchurrascoapp.dao.UsuarioDao;
import org.cesed.map.meuchurrascoapp.entities.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class UsuarioTest {

	@Test
	public void salvarTest() {
		Usuario usuario = new Usuario();
		UsuarioDao usuarioDao = new UsuarioDao();
		usuario.setEmail("davi@gmail");
		usuario.setNome("Davi");
		usuario.setPassword("dsadas");
		Assert.assertNotNull(usuarioDao.save(usuario));
	}
	
	@Test
	public void buscarTodosTest(){
		UsuarioDao usuarioDao = new UsuarioDao();
		Assert.assertNotNull(usuarioDao.findAll());
	}
	
	@Test
	public void buscarPorId(){
		UsuarioDao usuarioDao = new UsuarioDao();
		Assert.assertNotNull(usuarioDao.findById(6));
	}
	
	@Test
	public void atualizar(){
		Usuario usuario = new Usuario();
		UsuarioDao usuarioDao = new UsuarioDao();
		usuario.setNome("UsuarioTeste");
		usuario.setEmail("emailTeste");
		usuario.setPassword("dadada");
		usuario = usuarioDao.save(usuario);
		usuario.setPassword("99999");
		usuario = usuarioDao.update(usuario);
		Assert.assertEquals("99999", usuario.getPassword());
	}
	
	@Test
	public void remover(){
		Usuario usuario = new Usuario();
		UsuarioDao usuarioDao = new UsuarioDao();
		usuario.setNome("UsuarioTeste");
		usuario.setEmail("emailTeste");
		usuario.setPassword("dadada");
		usuario.setPassword("99999");
		usuario = usuarioDao.save(usuario);
		usuarioDao.remove(usuario);
		Assert.assertNull(usuarioDao.findById(usuario.getId()));
	}

}
