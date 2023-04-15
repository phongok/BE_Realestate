package com.se.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	
	private String  status;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Category(long id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}


	public Category() {
		super();
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	

	
	
}
