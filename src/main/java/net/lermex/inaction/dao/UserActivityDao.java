package net.lermex.inaction.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.lermex.inaction.entity.UserActivity;

@Component
public class UserActivityDao {
	
	@Autowired
	private EntityManagerFactory emf;
	
	public void createUserActivity(UserActivity ua) {
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			createUserActivity(entityManager, ua);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}
	
	public void createUserActivity(EntityManager entityManager, UserActivity ua) {				
		entityManager.persist(ua);
	}

}
