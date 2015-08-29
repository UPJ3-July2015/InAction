package net.lermex.inaction.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

import net.lermex.inaction.model.ActivityView;

@Component
public class ActivityViewDAO {
	
	@Autowired
	@Qualifier("my100app")
    private EntityManagerFactory emf;
	
	public List<ActivityView> getList() {
    	 EntityManager entityManager = emf.createEntityManager();
    	 try {    		
    		return entityManager.createNamedQuery("ActivityView.getAll", ActivityView.class).getResultList();     				
    	 } finally {
    		entityManager.close();	
    	 }		
	}
	

}
