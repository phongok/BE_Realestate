package com.se.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

public class NewsType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "idcategory")
	private Category category;

	private String name;

	private boolean isAction;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public NewsType(long id, Category category, String name, boolean isAction) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.isAction = isAction;
	}

	public NewsType() {
		super();
	}

	@Override
	public String toString() {
		return "BusinessType [id=" + id + ", category=" + category + ", name=" + name + ", isAction=" + isAction + "]";
	}

}
