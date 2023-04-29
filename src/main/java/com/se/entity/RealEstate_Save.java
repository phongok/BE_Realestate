package com.se.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity 
public class RealEstate_Save {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "idRealEstate")
	private RealEstate realEstate;

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

	public RealEstate getRealEstate() {
		return realEstate;
	}

	public void setRealEstate(RealEstate realEstate) {
		this.realEstate = realEstate;
	}

	public RealEstate_Save(long id, User user, RealEstate realEstate) {
		super();
		this.id = id;
		this.user = user;
		this.realEstate = realEstate;
	}

	public RealEstate_Save() {
		super();
	}

	@Override
	public String toString() {
		return "RealEstate_Save [id=" + id + ", user=" + user + ", realEstate=" + realEstate + "]";
	}
	
	
	
	
	
	
	
	
	
}
