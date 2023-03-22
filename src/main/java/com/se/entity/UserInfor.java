package com.se.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Infor_User")
public class UserInfor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JoinColumn(name = "idUser")
	private User user;

	@Column(name = "name")
	private String name;

	@Column(name = "phonenumber")
	private String phone;

	private double surplus;
	
	
	private String status;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public double getSurplus() {
		return surplus;
	}


	public void setSurplus(double surplus) {
		this.surplus = surplus;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public UserInfor(long id, User user, String name, String phone, double surplus, String status) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.phone = phone;
		this.surplus = surplus;
		this.status = status;
	}


	public UserInfor() {
		super();
	}


	@Override
	public String toString() {
		return "UserInfor [id=" + id + ", user=" + user + ", name=" + name + ", phone=" + phone + ", surplus=" + surplus
				+ ", status=" + status + "]";
	}
	
	
	



	

}
