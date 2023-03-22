package com.se.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


// Nhà hoặc khách sạn

@Entity
@Table(name= "Home")
public class Home {
	
	@Id
	private UUID id;  // id nhà
	
	@OneToOne
	@JoinColumn(name= "idCategory")
	private Category category;    // id danh mục
	
	@OneToOne
	@JoinColumn(name = "idBusinessType")
	private BusinessType businessType; // id loại kinh doanh
	
	@ManyToOne
	@JoinColumn(name = "idUser") // người đăng
	private User user;
	
	@Column(name = "name")
	private String name;   // tên bài đăng
	
	
	private float length; // chiều dài
	
	private float width; // chiều rộng
	
	private float acreage; // diện tích
	
	private String price; // giá
	
	@Column(name = "date_submitted")
	@Temporal(TemporalType.DATE)
	private Date dateSubmitted;  // ngày đăng
	
	private String status;  // trạng thái
	
	private int room;  // số phòng
	
	private int floor;  // số tầng
	
	private String address;  // địa chỉ
	
	private String decription; // mô tả
	

	
	
	
}
