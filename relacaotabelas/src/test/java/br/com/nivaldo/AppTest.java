package br.com.nivaldo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.nivaldo.dao.IMarcaDAO;
import br.com.nivaldo.dao.MarcaDAO;
import br.com.nivaldo.domain.Marca;

public class AppTest {
	
	private IMarcaDAO marcaDAO;

	public AppTest() {
		marcaDAO = new MarcaDAO();
	}

	@Test
	public void cadastrar() {
		Marca marca = new Marca();
		marca.setCodigo("A1");
		marca.setDescricao("Carros eletricos");
		marca.setNome("Tesla");
		marca = marcaDAO.cadastrar(marca);

		assertNotNull(marca);
		assertNotNull(marca.getId());
	}
}
