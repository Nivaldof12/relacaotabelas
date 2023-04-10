package br.com.nivaldo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.Instant;

import org.junit.Test;

import br.com.nivaldo.dao.AcessorioDAO;
import br.com.nivaldo.dao.CarroDAO;
import br.com.nivaldo.dao.IAcessorioDAO;
import br.com.nivaldo.dao.ICarroDAO;
import br.com.nivaldo.dao.IMarcaDAO;
import br.com.nivaldo.dao.MarcaDAO;
import br.com.nivaldo.domain.Acessorio;
import br.com.nivaldo.domain.Carro;
import br.com.nivaldo.domain.Marca;

public class AppTest2 {

	private ICarroDAO carroDAO;

	private IMarcaDAO marcaDAO;

	private IAcessorioDAO acessorioDAO;

	public AppTest2() {
		carroDAO = new CarroDAO();
		marcaDAO = new MarcaDAO();
		acessorioDAO = new AcessorioDAO();
	}

	@Test
	public void cadastrar() {
		Marca marca = criarMarca("A1");
		Acessorio acessorio = criarAcessorio("A1");

		Carro carro = new Carro();
		carro.setCodigo("A1");
		carro.setDataCarro(Instant.now());
		carro.setStatus("ATIVA");
		carro.setValor(200000d);
		carro.setMarca(marca);
		carro.setAcessorio(acessorio);

		acessorio.setCarro(carro);
		carro = carroDAO.cadastrar(carro);

		assertNotNull(carro);
		assertNotNull(carro.getId());

		Carro carBD = carroDAO.buscarPorCodigoMarca(carro.getCodigo());
		assertNotNull(carBD);
		assertEquals(carro.getId(), carBD.getId());

		Carro carBDObj = carroDAO.buscarPorMarca(marca);
		assertNotNull(carBDObj);
		assertEquals(carro.getId(), carBDObj.getId());
	}

	private Acessorio criarAcessorio(String codigo) {
		Acessorio acessorio = new Acessorio();
		acessorio.setCodigo(codigo);
		acessorio.setNome("multimidia");
		return acessorioDAO.cadastrar(acessorio);
	}

	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setDescricao("Carro eletrico");
		marca.setNome("Tesla");
		return marcaDAO.cadastrar(marca);
	}
}
