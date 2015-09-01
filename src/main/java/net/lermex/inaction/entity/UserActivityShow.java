package net.lermex.inaction.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "scuser_activities_show")
@NamedQueries({
	@NamedQuery(name = "UserActivityShow.getAllActivitiesOrderByDt", query = "SELECT a FROM UserActivityShow a ORDER BY a.dt") })
public class UserActivityShow {
	
	@Id
	private Long Id;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "user_name", length = 4000)
	private String userName;
	
	@Column(name = "ACTIVITY_ID")
	private Long activityId;
	
	@Column(name = "sport_activities_name", length = 4000)
	private String sportActivityName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT")
	private Date dt;
	
	@Column(name="MINUTES")
	private Integer minutes;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getSportActivityName() {
		return sportActivityName;
	}

	public void setSportActivityName(String sportActivityName) {
		this.sportActivityName = sportActivityName;
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
