package br.com.nivaldo.dao;

import br.com.nivaldo.domain.Carro;
import br.com.nivaldo.domain.Marca;

public interface ICarroDAO {
	Carro cadastrar(Carro carro);

	Carro buscarPorCodigoMarca(String codigoMarca);

	Carro buscarPorMarca(Marca marca);
}
