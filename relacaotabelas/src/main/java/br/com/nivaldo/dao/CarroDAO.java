package br.com.nivaldo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.nivaldo.domain.Carro;
import br.com.nivaldo.domain.Marca;

public class CarroDAO implements ICarroDAO {

	@Override
	public Carro cadastrar(Carro carro) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(carro);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();

		return carro;
	}

	@Override
	public Carro buscarPorCodigoMarca(String codigoMarca) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT m FROM Carro m ");
		sb.append("INNER JOIN Marca c on c = m.marca ");
		sb.append("WHERE c.codigo = :codigoMarca");

		entityManager.getTransaction().begin();
		TypedQuery<Carro> query = entityManager.createQuery(sb.toString(), Carro.class);
		query.setParameter("codigoMarca", codigoMarca);
		Carro carro = query.getSingleResult();

		entityManager.close();
		entityManagerFactory.close();

		return carro;
	}

	@Override
	public Carro buscarPorMarca(Marca marca) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT m FROM Carro m ");
		sb.append("INNER JOIN Marca c on c = m.marca ");
		sb.append("WHERE c = :marca");

		entityManager.getTransaction().begin();
		TypedQuery<Carro> query = entityManager.createQuery(sb.toString(), Carro.class);
		query.setParameter("marca", marca);
		Carro carro = query.getSingleResult();

		entityManager.close();
		entityManagerFactory.close();

		return carro;
	}

}
