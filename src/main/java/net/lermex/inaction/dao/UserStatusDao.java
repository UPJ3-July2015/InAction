package net.lermex.inaction.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.lermex.inaction.entity.UserStatus;
import net.lermex.inaction.entity.UserStatusListDto;

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
	
	public Long addUserStatus(UserStatus us) {
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(us);
			entityManager.getTransaction().commit();
			return us.getId();
		} finally {
			entityManager.close();
		}
	}
	
	public List<UserStatus> getAll() {
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			List<UserStatus> listPosts = entityManager.createQuery("SELECT p FROM UserStatus p", UserStatus.class).getResultList();
			entityManager.getTransaction().commit();
			return listPosts;
		} finally {
			entityManager.close();
		}		
	}
	
	//Get last inserted Id
	public Long getHiPostId(EntityManager entityManager) {
		return entityManager.createQuery("SELECT max(p.Id) FROM UserStatus p", Long.class).getSingleResult();
	}
		
	//Get Records where Id is owns interval: [minId, maxId]
	public UserStatusListDto getUserStatusFrom(Long BegId) {
		EntityManager entityManager = emf.createEntityManager();
		try {
		  Long hiId = getHiPostId(entityManager);
		  List<UserStatus> list = entityManager
				  .createQuery("SELECT p FROM UserStatus p WHERE p.Id >= :BegId AND p.Id <= :EndId", UserStatus.class)
				  .setParameter("BegId", BegId)
				  .setParameter("EndId", hiId).getResultList();
		  return new UserStatusListDto(list, BegId, hiId);
		} finally {
			entityManager.close();
		}			
	}
	
	
	
}
