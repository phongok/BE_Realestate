package com.se.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "accuser")
	private User accuser;
	
	@ManyToOne
	@JoinColumn(name = "cheat")
	private User cheat;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateReport;
	
	private String status;
	
	private String content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getAccuser() {
		return accuser;
	}

	public void setAccuser(User accuser) {
		this.accuser = accuser;
	}

	public User getCheat() {
		return cheat;
	}

	public void setCheat(User cheat) {
		this.cheat = cheat;
	}

	public Date getDateReport() {
		return dateReport;
	}

	public void setDateReport(Date dateReport) {
		this.dateReport = dateReport;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Report(long id, User accuser, User cheat, Date dateReport, String status, String content) {
		super();
		this.id = id;
		this.accuser = accuser;
		this.cheat = cheat;
		this.dateReport = dateReport;
		this.status = status;
		this.content = content;
	}

	public Report() {
		super();
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", accuser=" + accuser + ", cheat=" + cheat + ", dateReport=" + dateReport
				+ ", status=" + status + ", content=" + content + "]";
	}
	
	
	
	
}
