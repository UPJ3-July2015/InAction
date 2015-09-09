package net.lermex.inaction.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import net.lermex.inaction.dao.JsonDateSerializer;
import net.lermex.inaction.json.ViewsHolder;

@JsonAutoDetect
@Entity
@Table(name = "scuser_statuses")
public class UserStatus {

	@JsonView(ViewsHolder.Post.class)
	@Id
	@GeneratedValue(generator = "userstatus_seq")
	@SequenceGenerator(name = "userstatus_seq", sequenceName = "SC_SEQ", allocationSize = 1)
	private Long Id;
	
	@JsonView(ViewsHolder.Post.class)
	@ManyToOne
	@JoinColumn(name="USER_ID", referencedColumnName="ID")
	private User user;
	
	@JsonView(ViewsHolder.Post.class)
	/* @JsonSerialize(using=JsonDateSerializer.class) - java.lang.IllegalStateException: getOutputStream() has already been called for this response */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_dt")
	private Date createDt;
	
	@JsonView(ViewsHolder.Post.class)
	@Column(name = "user_text", length = 4000)
	private String userText;
	
	public UserStatus() {}
	public UserStatus(User user) { this.user = user;}
	
	@PrePersist
	private void setDtBeforeInsert() {
		if (createDt == null) {
			createDt = new Date();
		}
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreateDt() {
		return createDt;
	}
	public void setCreateDt(Date dt) {
		this.createDt = dt;
	}
	public String getUserText() {
		return userText;
	}
	public void setUserText(String userText) {
		this.userText = userText;
	}		
	
}
