package net.lermex.inaction.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.lermex.inaction.entity.UserStatus;

@Component
public class UserStatusDao {

	@Autowired
	private EntityManagerFactory emf;
	
	public void createUserStatus(UserStatus us) {
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(us);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}
}
