package net.lermex.inaction.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "scuser_activities")
public class UserActivity {

	@Id
	@GeneratedValue(generator = "useractivity_seq")
	@SequenceGenerator(name = "useractivity_seq", sequenceName = "SC_SEQ", allocationSize = 1)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name="USER_ID", referencedColumnName="ID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="ACTIVITY_ID", referencedColumnName="ID")
	private SportActivity activity;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT")
	private Date dt;
	
	@Column(name="MINUTES")
	private Integer minutes;
	
	public UserActivity() {}
	public UserActivity(User user, SportActivity activity) {
		this.user = user;
		this.activity = activity;
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
	public SportActivity getActivity() {
		return activity;
	}
	public void setActivity(SportActivity activity) {
		this.activity = activity;
	}
	public Date getDt() {
		return dt;
	}
	public void setDt(Date dt) {
		this.dt = dt;
	}
	public Integer getMinutes() {
		return minutes;
	}
	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}		
	
}
