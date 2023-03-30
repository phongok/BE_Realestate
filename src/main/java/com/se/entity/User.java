package com.se.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6990795570828179037L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
	
	private String url;
	
	@Column(name = "name")
	private String name;

	@Column(name = "phonenumber")
	private String phone;

	private double surplus;
	
	
	private String status;
	
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "user_role_map", joinColumns = {@JoinColumn(name = "idUser")},
//    inverseJoinColumns = {@JoinColumn(name = "idRole")})
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="user_role_map",
		joinColumns = @JoinColumn(
			name="idUser",
			referencedColumnName = "id"
		),
		inverseJoinColumns = @JoinColumn(
			name="idRole",
			referencedColumnName = "id"
		)
	)
	private Set<Role> roles;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public User() {
	}
	
	public User(long id, String username, String password, String url, String name, String phone, double surplus,
			String status, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.url = url;
		this.name = name;
		this.phone = phone;
		this.surplus = surplus;
		this.status = status;
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles + "]";
	}
}
