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
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "idRealEstate")
	private RealEstate realEstate;
	
	@Temporal(TemporalType.DATE)
	private Date datepay;
	
	@Temporal(TemporalType.TIME)
	private Date timepay;
	
	private double totalmoney;

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

	public Date getDatepay() {
		return datepay;
	}

	public void setDatepay(Date datepay) {
		this.datepay = datepay;
	}

	public Date getTimepay() {
		return timepay;
	}

	public void setTimepay(Date timepay) {
		this.timepay = timepay;
	}

	public double getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(double totalmoney) {
		this.totalmoney = totalmoney;
	}

	public Bill(long id, User user, RealEstate realEstate, Date datepay, Date timepay, double totalmoney) {
		super();
		this.id = id;
		this.user = user;
		this.realEstate = realEstate;
		this.datepay = datepay;
		this.timepay = timepay;
		this.totalmoney = totalmoney;
	}

	public Bill() {
		super();
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", user=" + user + ", realEstate=" + realEstate + ", datepay=" + datepay
				+ ", timepay=" + timepay + ", totalmoney=" + totalmoney + "]";
	}
	
	
	
	
	
}
