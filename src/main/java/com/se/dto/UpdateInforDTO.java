package com.se.dto;

public class UpdateInforDTO {
	private long idUserUpdate;
	private String nameUpdate;
	private String emailUpdate;
	private String phoneUpdate;
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
	public void setPhoneUpdate(String phoneUpdate) {
		this.phoneUpdate = phoneUpdate;
	}
	public String getImg1Update() {
		return img1Update;
	}
	public void setImg1Update(String img1Update) {
		this.img1Update = img1Update;
	}
	public UpdateInforDTO(long idUserUpdate, String nameUpdate, String emailUpdate, String phoneUpdate,
			String img1Update) {
		super();
		this.idUserUpdate = idUserUpdate;
		this.nameUpdate = nameUpdate;
		this.emailUpdate = emailUpdate;
		this.phoneUpdate = phoneUpdate;
		this.img1Update = img1Update;
	}
	public UpdateInforDTO() {
		super();
	}
	@Override
	public String toString() {
		return "UpdateInforDTO [idUserUpdate=" + idUserUpdate + ", nameUpdate=" + nameUpdate + ", emailUpdate="
				+ emailUpdate + ", phoneUpdate=" + phoneUpdate + ", img1Update=" + img1Update + "]";
	}
	
	
}
