package net.lermex.inaction.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name = "ACTVITY_VIEW")
@NamedQueries({	  
	  @NamedQuery(name="ActivityView.getAll", query="SELECT a FROM ACTVITY_VIEW a")
	})
public class ActivityView {
	
	@Id	
	@Column(name="ID")
	private int id;
	
	@Column(name="DT")
	private Date dt;
	
	@Column(name="DT_CHR")
	private String dtChr;
	
	@Column(name="SUBJ_NAME")
	private String subjName;
	
	@Column(name="VERB_SYSNAME")
	private String verbName;
	
	@Column(name="VERB_SHOWNAME")
	private String verbShowName;
	
	@Column(name="OBJECT_ID")
	private int objectId;
	
	@Column(name="OBJTYPE")
	private String objectType;
	
	@Column(name="OBJECT_VALUE")
	private String objectValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public String getDtChr() {
		return dtChr;
	}

	public void setDtChr(String dtChr) {
		this.dtChr = dtChr;
	}

	public String getSubjName() {
		return subjName;
	}

	public void setSubjName(String subjName) {
		this.subjName = subjName;
	}

	public String getVerbName() {
		return verbName;
	}

	public void setVerbName(String verbName) {
		this.verbName = verbName;
	}

	public String getVerbShowName() {
		return verbShowName;
	}

	public void setVerbShowName(String verbShowName) {
		this.verbShowName = verbShowName;
	}

	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getObjectValue() {
		return objectValue;
	}

	public void setObjectValue(String objectValue) {
		this.objectValue = objectValue;
	}

}
