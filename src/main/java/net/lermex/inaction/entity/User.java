package net.lermex.inaction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
@Table(name="scusers")
public class User {
	
	@Id
	@GeneratedValue(generator="user_seq")
	@SequenceGenerator(name="user_seq",sequenceName="SC_SEQ", allocationSize=1)
	Long Id;
	
	@Column(name="name", length=40)
	String name;
	
	@Column(name="passwordhash", length=64)
	String passwordhash;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswordhash() {
		return passwordhash;
	}

	public void setPasswordhash(String passwordhash) {
		this.passwordhash = passwordhash;
	}
		

}
