package net.lermex.inaction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "scsport_activities")
@NamedQueries({
		@NamedQuery(name = "User.getActivityByName", query = "SELECT a FROM SportActivity a where a.name = :usern"),
		@NamedQuery(name = "User.getAllActivitiesOrderByName", query = "SELECT a FROM SportActivity a ORDER BY a.name") })
public class SportActivity {

	@Id
	@GeneratedValue(generator = "sports_seq")
	@SequenceGenerator(name = "sports_seq", sequenceName = "SC_SEQ", allocationSize = 1)
	Long Id;

	@Column(name = "name", length = 40)
	String name;

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

}
