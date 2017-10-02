package br.com.db1.model;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class CidadeTest {
	
	@Test
	public void metodoTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();
				
		Cidade2 cidade = new Cidade2();
		cidade.setNome("Maringa");
		cidade.setUf(Uf.PR);
		manager.getTransaction().begin();
		manager.persist(cidade);
		manager.getTransaction().commit();
		
		factory.close();

	}
	
	@Test
	public void deleteTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();
				
		Cidade2 cidade = manager.find(Cidade2.class, 3L);
		manager.getTransaction().begin();
		manager.remove(cidade);
		manager.getTransaction().commit();
		
		factory.close();

	}
	
	@Test
	public void updateTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();
				
		Cidade2 cidade = manager.find(Cidade2.class, 2L);
		cidade.setNome("Maringa");
		manager.getTransaction().begin();
		manager.persist(cidade);
		manager.getTransaction().commit();
		
		factory.close();

	}
	
	@Test
	public void selectHqlTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();
				
		Query query = manager.createQuery("Select c from Cidade c");
		List<Cidade2> cidades = query.getResultList();
		
		factory.close();

	}
	
	@Test
	public void selectSqlNativoTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();
				
		Query query = manager.createNativeQuery("Select * from cidade c");
		List<Cidade2> cidades = query.getResultList();
		
		factory.close();

	}

	

}
