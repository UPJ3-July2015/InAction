package net.lermex.inaction.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.lermex.inaction.entity.UserActivityShow;

@Component
public class UserActivityShowDao {
	
	@Autowired
	private EntityManagerFactory emf;
	
	public List<UserActivityShow> getUserActivityShowList() {
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			try {
			  return entityManager.createNamedQuery("UserActivityShow.getAllActivitiesOrderByDt", UserActivityShow.class).getResultList();
			} finally {
			 entityManager.getTransaction().commit();
			}
		} finally {
			entityManager.close();
		}
	}

}
