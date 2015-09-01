package net.lermex.inaction.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.lermex.inaction.entity.SportActivity;

@Component
public class SportActivityDao {

	@Autowired
	private EntityManagerFactory emf;

	public void createActivity(SportActivity a) {
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(a);
			entityManager.getTransaction().commit();
		} finally {
			emf.close();
		}
	}

}
