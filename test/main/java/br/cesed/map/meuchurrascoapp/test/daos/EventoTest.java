package br.cesed.map.meuchurrascoapp.test.daos;

import java.util.Date;

import org.cesed.map.meuchurrascoapp.dao.EventoDao;
import org.cesed.map.meuchurrascoapp.dao.UsuarioDao;
import org.cesed.map.meuchurrascoapp.entities.Evento;
import org.cesed.map.meuchurrascoapp.entities.Usuario;
import org.junit.Test;

import org.junit.*;

public class EventoTest {

	@Test
	public void salvarEventoTest() {
		
		EventoDao eventoDao = new EventoDao();
		UsuarioDao usuarioDao = new UsuarioDao();
		
		Evento evento = new Evento();
		evento.setData(new Date());
		evento.setDescricao("descricaoTeste");
		evento.setLocal("Local teste");
		evento.setNome("Nome evento teste");
		
		Usuario usuario = new Usuario();
		usuario.setEmail("marcelo@gmail.com");
		usuario.setNome("Marcelo");
		usuario.setPassword("password");
		usuario = usuarioDao.save(usuario);
		
		evento.setOrganizador(usuario);
		
		Assert.assertNotNull(eventoDao.save(evento));
	}
	
	@Test
	public void buscaPorIdTest(){
		EventoDao eventoDao = new EventoDao();
		UsuarioDao usuarioDao = new UsuarioDao();
		
		Evento evento = new Evento();
		evento.setData(new Date());
		evento.setDescricao("descricaoTeste");
		evento.setLocal("Local teste");
		evento.setNome("Nome evento teste");
		
		Usuario usuario = new Usuario();
		usuario.setEmail("marcelo@gmail.com");
		usuario.setNome("Marcelo");
		usuario.setPassword("password");
		usuario = usuarioDao.save(usuario);
		
		evento = eventoDao.save(evento);
		
		Assert.assertNotNull(eventoDao.findById(evento.getId()));
	}
	
	@Test
	public void buscarPorOrganizadorTest(){
		
		EventoDao eventoDao = new EventoDao();
		UsuarioDao usuarioDao = new UsuarioDao();
		
		Evento evento = new Evento();
		evento.setData(new Date());
		evento.setDescricao("descricaoTeste");
		evento.setLocal("Local teste");
		evento.setNome("Nome evento teste");
		
		Usuario usuario = new Usuario();
		usuario.setEmail("marcelo@gmail.com");
		usuario.setNome("Marcelo");
		usuario.setPassword("password");
		usuario = usuarioDao.save(usuario);
		
		evento = eventoDao.save(evento);
		
		Assert.assertNotNull(eventoDao.findEventoByOrganizador(usuario.getId()));
	}
	
	@Test
	public void buscarTodosTest(){
		EventoDao dao = new EventoDao();
		Assert.assertNotNull(dao.findAll());
	}
	
	@Test
	public void removerTest(){
		EventoDao eventoDao = new EventoDao();
		UsuarioDao usuarioDao = new UsuarioDao();
		
		Evento evento = new Evento();
		evento.setData(new Date());
		evento.setDescricao("descricaoTeste");
		evento.setLocal("Local teste");
		evento.setNome("Nome evento teste");
		
		Usuario usuario = new Usuario();
		usuario.setEmail("marcelo@gmail.com");
		usuario.setNome("Marcelo");
		usuario.setPassword("password");
		usuario = usuarioDao.save(usuario);
		
		evento = eventoDao.save(evento);
		
		eventoDao.remove(evento);
		
		Assert.assertNull(eventoDao.findById(evento.getId()));
	}
	
	@Test
	public void atualizarTest(){
		EventoDao eventoDao = new EventoDao();
		UsuarioDao usuarioDao = new UsuarioDao();
		
		Evento evento = new Evento();
		evento.setData(new Date());
		evento.setDescricao("descricaoTeste");
		evento.setLocal("Local teste");
		evento.setNome("Nome evento teste");
		
		Usuario usuario = new Usuario();
		usuario.setEmail("marcelo@gmail.com");
		usuario.setNome("Marcelo");
		usuario.setPassword("password");
		usuario = usuarioDao.save(usuario);
		
		evento = eventoDao.save(evento);
		
		evento.setLocal("FACISA");
		
		evento = eventoDao.update(evento);
		
		Assert.assertEquals("FACISA", evento.getLocal());
	}

}
