package com.se.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	
	private boolean isAction;

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

	public boolean isAction() {
		return isAction;
	}

	public void setAction(boolean isAction) {
		this.isAction = isAction;
	}

	public Category(long id, String name, boolean isAction) {
		super();
		this.id = id;
		this.name = name;
		this.isAction = isAction;
	}

	public Category() {
		super();
	}

	public Category(long id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", isAction=" + isAction + "]";
	}
	
	
	
	
}
