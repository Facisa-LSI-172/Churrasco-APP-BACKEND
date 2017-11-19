package br.cesed.map.meuchurrascoapp.test.daos;


import org.cesed.map.meuchurrascoapp.dao.ContribuicaoDao;
import org.cesed.map.meuchurrascoapp.dao.UsuarioDao;
import org.cesed.map.meuchurrascoapp.entities.Contribuicao;
import org.cesed.map.meuchurrascoapp.entities.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class ContribuicaoTest {

	@Test
	public void salvarTest() {
		ContribuicaoDao cDao = new ContribuicaoDao();
		UsuarioDao uDao = new UsuarioDao();
		
		Contribuicao c = new Contribuicao();
		
		Usuario u = new Usuario();
		u.setNome("Usuario teste");
		u.setPassword("pass");
		u.setEmail("teste@teste");
		u = uDao.save(u);
		
		c.setNome("carne de sol teste");
		c.setContribuidor(u);
		
		Assert.assertNotNull(cDao.save(c));
	}
	
	@Test
	public void removerTest(){
		ContribuicaoDao cDao = new ContribuicaoDao();
		UsuarioDao uDao = new UsuarioDao();
		
		Usuario u = new Usuario();
		u.setNome("Usuario teste");
		u.setPassword("pass");
		u.setEmail("teste@teste");
		u = uDao.save(u);
		
		Contribuicao c = new Contribuicao();
		c.setNome("carne de sol teste");
		c.setContribuidor(u);
		
		c = cDao.save(c);
		
		cDao.remove(c);
		
		Assert.assertNull(cDao.findById(c.getId()));
	}
	
	@Test
	public void atualizarTest(){
		ContribuicaoDao cDao = new ContribuicaoDao();
		UsuarioDao uDao = new UsuarioDao();
		
		Contribuicao c = new Contribuicao();
		
		Usuario u = new Usuario();
		u.setNome("Usuario teste");
		u.setPassword("pass");
		u.setEmail("teste@teste");
		u = uDao.save(u);
		
		c.setNome("carne de sol teste");
		c.setContribuidor(u);
		
		c = cDao.save(c);
		
		c.setNome("Carne de charque");
		
		c = cDao.update(c);
		
		Assert.assertEquals("Carne de charque", c.getNome());
		
	}

}
