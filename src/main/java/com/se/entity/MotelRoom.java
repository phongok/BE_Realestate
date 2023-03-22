package com.se.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Phòng trọ

@Entity
@Table(name= "motel_room")
public class MotelRoom {
	@Id
	private UUID id; // id Phòng trọ
	
	@OneToOne
	@JoinColumn(name= "idCategory")
	private Category category; // Id Danh mục
	
	@OneToOne
	@JoinColumn(name = "idBusinessType")
	private BusinessType businessType; // Id loại bài đăng
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;  // Id người đăng
	
	@Column(name = "name")
	private String name; // tên bài đăng
	
	
	private float length; // Chiều dài phòng
	
	private float width;  // chiều rộng phòng
	
	private float acreage; // diện tích phòng
	
	private String price; // giá
	
	@Column(name = "date_submitted")
	@Temporal(TemporalType.DATE)
	private Date dateSubmitted;  // ngày đăng
	
	private String status; // trạng thái
	
	private String address;  // địa chỉ
	
	private String decription; // mô tả
	

}
