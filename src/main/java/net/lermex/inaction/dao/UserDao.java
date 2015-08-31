package net.lermex.inaction.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.lermex.inaction.entity.User;

@Component
public class UserDao {
	
	@Autowired
	private EntityManagerFactory emf;
	
	public void createUser(User u) {
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(u);
			entityManager.getTransaction().commit();
		} finally {
			
		}
	}

}
