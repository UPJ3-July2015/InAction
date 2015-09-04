package net.lermex.inaction.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "SCUSER_AVATAR")
public class UserAvatarShow {

	@Id	
	private Long Id;	
	
	@Basic(fetch=FetchType.EAGER)
	@Column(name = "photo")
	private byte[] avatar;
	
	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

}
