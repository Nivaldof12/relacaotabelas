package br.com.nivaldo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.nivaldo.domain.Marca;

public class MarcaDAO implements IMarcaDAO {

	@Override
	public Marca cadastrar(Marca marca) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(marca);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();

		return marca;
	}

}
