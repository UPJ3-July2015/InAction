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

	private int getUserCount(EntityManager entityManager, String aUserName) {
		return (entityManager.createNamedQuery("User.getCountByUserName", Long.class).setParameter("usern", aUserName))
				.getSingleResult().intValue();
	}

	private int getUserCount(EntityManager entityManager, User u) {
		return getUserCount(entityManager, u.getName());
	}

	/*
	 * look createUserIfNotExists.
	 * This method creates User without checking
	 */
	public void createUser(User u) {
		if (u == null)
			return;
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(u);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	/*
	 * If User does not exists, this method will return false
	 */
	public boolean checkUser(User u) {
		if (u == null)
			return false;
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();			
			int count = getUserCount(entityManager, u);			
			entityManager.getTransaction().commit();
			return (count > 0);
		} finally {
			entityManager.close();
		}
	}

	/*
	 * If User does not exists, this method will return false
	 */
	public boolean checkUserName(String aUserName) {
		int count = -1;
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			try {
				return ((count = getUserCount(entityManager, aUserName)) > 0); 								
			} finally {
				if (count > -1)
				   entityManager.getTransaction().commit();
			}
		} finally {
			entityManager.close();
		}
	}

	/*
	 * If User does not exists, this method will create it and return true
	 */
	public boolean createUserIfNotExists(final User u) {
		if (u == null)
			return false;
		final EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			boolean result = (getUserCount(entityManager, u) > 0) ? false : Boolean.valueOf(new Object() {
				public String toString() {
					entityManager.persist(u);					
					return "true";
				}
			}.toString());					
			entityManager.getTransaction().commit();			
			return result;			
		} finally {
			entityManager.close();
		}
	}
	
	public User getUserById(Long Id) {
		EntityManager entityManager = emf.createEntityManager();
		try {
			return entityManager.find(User.class, Id);
		} finally {
			entityManager.close();
		}
	}

}
