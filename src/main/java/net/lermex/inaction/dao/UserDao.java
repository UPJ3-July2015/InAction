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
		return (entityManager.createNamedQuery("User.getCountByUserName", Long.class).setParameter("usern", aUserName)).getSingleResult().intValue();
	}
	
	private int getUserCount(EntityManager entityManager, User u) {
		return getUserCount(entityManager, u.getName());
	}
	
	/*
	 * см. createUserW
	 * этот метод создает пользователя без проверки
	 */
	public void createUser(User u) {
		if (u == null) return;
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(u);
			entityManager.getTransaction().commit();
		} finally {
			emf.close();
		}
	}
	
	/*
	 * Проверка пользователя на существование 
	 */
	public boolean checkUser(User u) {
		if (u == null) return false;
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			try {
				return ( getUserCount(entityManager, u) > 0);
			} finally {
              entityManager.getTransaction().commit();
			}
		} finally {
			emf.close();
		}
	}
	
	/*
	 * Проверка того, что есть пользователь с таким именем 
	 */
	public boolean checkUserName(String aUserName) {
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			try {
				return ( getUserCount(entityManager, aUserName) > 0);
			} finally {
              entityManager.getTransaction().commit();
			}
		} finally {
			emf.close();
		}
	}
	
	/*
	 * Если такого пользователя не существует, он будет создан и метод вернет - true
	 */
	public boolean createUserW(User u) {
		if (u == null) return false;
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			try {
			  int uCount = getUserCount(entityManager, u);
			  if (uCount > 0) return false; 
			  entityManager.persist(u);
			  return true;
			} finally {
			 entityManager.getTransaction().commit();
			}
		} finally {
			emf.close();
		}
	}

}
