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
			entityManager.close();
		}
	}
	
	public SportActivity getActivityByName(EntityManager entityManager, String aName) {
		return (entityManager.createNamedQuery("SportAct.getActivityByName", SportActivity.class).setParameter("usern", aName))
				.getSingleResult();
	}
	
	public SportActivity getActivityByName(String aName) {
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
	        try {
	        	return getActivityByName(entityManager, aName);
	        } finally {
			  entityManager.getTransaction().commit();
	        }
		} finally {
			entityManager.close();
		}
	}

}
