package br.cesed.map.meuchurrascoapp.test.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cesed.map.meuchurrascoapp.dao.EventoDao;
import org.cesed.map.meuchurrascoapp.dao.UsuarioDao;
import org.cesed.map.meuchurrascoapp.entities.Evento;
import org.cesed.map.meuchurrascoapp.entities.Usuario;
import org.junit.Assert;
import org.junit.Test;

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
	public void adicionarParticipantes(){
		
		UsuarioDao uDao = new UsuarioDao();
		EventoDao eDao = new EventoDao();
		
		Usuario u = new Usuario();
		Usuario u1 = new Usuario();
		Usuario u2 = new Usuario();
		
		u.setEmail("email1");
		u1.setEmail("email2");
		u2.setEmail("email3");
		
		u.setNome("nome");
		u1.setNome("nome1");
		u2.setNome("nome2");
		
		u.setPassword("123");
		u1.setPassword("122");
		u2.setPassword("124");
		
		u = uDao.save(u);
		u1 = uDao.save(u1);
		u2 = uDao.save(u2);
		
		Evento e = new Evento();
		e.setData(new Date());
		e.setDescricao("descricao");
		e.setLocal("local");
		e.setNome("nome evento");
		
		e.setOrganizador(u);
		
		e = eDao.save(e);
		
		List<Usuario> listaParticipantes = new ArrayList<>();
		listaParticipantes.add(u);
		listaParticipantes.add(u1);
		listaParticipantes.add(u2);

		e.setListaParticipantes(listaParticipantes);
		
		eDao.update(e);
		
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
