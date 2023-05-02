package com.se.dto;

public class UserUpdate {
	private long idUserUpdate;
	private String nameUpdate;
	private String emailUpdate;
	private String phoneUpdate;
	private double surplusUpdate;
	private String statusUpdate;
	private String img1Update;
	public long getIdUserUpdate() {
		return idUserUpdate;
	}
	public void setIdUserUpdate(long idUserUpdate) {
		this.idUserUpdate = idUserUpdate;
	}
	public String getNameUpdate() {
		return nameUpdate;
	}
	public void setNameUpdate(String nameUpdate) {
		this.nameUpdate = nameUpdate;
	}
	public String getEmailUpdate() {
		return emailUpdate;
	}
	public void setEmailUpdate(String emailUpdate) {
		this.emailUpdate = emailUpdate;
	}
	public String getPhoneUpdate() {
		return phoneUpdate;
	}
	
	public String getStatusUpdate() {
		return statusUpdate;
	}
	public void setStatusUpdate(String statusUpdate) {
		this.statusUpdate = statusUpdate;
	}
	public void setPhoneUpdate(String phoneUpdate) {
		this.phoneUpdate = phoneUpdate;
	}
	public double getSurplusUpdate() {
		return surplusUpdate;
	}
	public void setSurplusUpdate(double surplusUpdate) {
		this.surplusUpdate = surplusUpdate;
	}
	public String getImg1Update() {
		return img1Update;
	}
	public void setImg1Update(String img1Update) {
		this.img1Update = img1Update;
	}
	
	public UserUpdate(long idUserUpdate, String nameUpdate, String emailUpdate, String phoneUpdate,
			double surplusUpdate, String statusUpdate, String img1Update) {
		super();
		this.idUserUpdate = idUserUpdate;
		this.nameUpdate = nameUpdate;
		this.emailUpdate = emailUpdate;
		this.phoneUpdate = phoneUpdate;
		this.surplusUpdate = surplusUpdate;
		this.statusUpdate = statusUpdate;
		this.img1Update = img1Update;
	}
	public UserUpdate() {
		super();
	}
	@Override
	public String toString() {
		return "UserUpdate [idUserUpdate=" + idUserUpdate + ", nameUpdate=" + nameUpdate + ", emailUpdate="
				+ emailUpdate + ", phoneUpdate=" + phoneUpdate + ", surplusUpdate=" + surplusUpdate + ", statusUpdate="
				+ statusUpdate + ", img1Update=" + img1Update + "]";
	}
	
	
	
	
	
}
