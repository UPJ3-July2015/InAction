package net.lermex.inaction.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.lermex.inaction.entity.UserAvatarShow;

@Component
public class UserAvatarShowDao {
	
	@Autowired
	private EntityManagerFactory emf;
	
	
	public UserAvatarShow getAvatarById(Long id) {		
		EntityManager entityManager = emf.createEntityManager();
		try {
			return entityManager.find(UserAvatarShow.class, id);
		} finally {
			entityManager.close();
		}
	}
	
	public byte[] getAvatarImageById(Long id) {
		UserAvatarShow u = null;
		return ((/*UserAvatarShow*/ u = getAvatarById(id)) == null) ? null : (u.getAvatar());
	}

}
