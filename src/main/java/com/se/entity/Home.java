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
@Table(name = "Home")
public class Home {

	@Id
	private UUID id; // id nhà

	@OneToOne
	@JoinColumn(name = "idCategory")
	private Category category; // id danh mục

	@OneToOne
	@JoinColumn(name = "idBusinessType")
	private BusinessType businessType; // id loại kinh doanh

	@ManyToOne
	@JoinColumn(name = "idUser") // người đăng
	private User user;

	@Column(name = "name")
	private String name; // tên bài đăng

	private float length; // chiều dài

	private float width; // chiều rộng

	private float acreage; // diện tích

	private String price; // giá

	@Column(name = "date_submitted")
	@Temporal(TemporalType.DATE)
	private Date dateSubmitted; // ngày đăng

	private String status; // trạng thái

	private String address; // địa chỉ

	private String decription; // mô tả

	private String url_img1;
	private String url_img2;
	private String url_img3;
	private String url_img4;
	private String url_img5;
	private String url_img6;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
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

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getAcreage() {
		return acreage;
	}

	public void setAcreage(float acreage) {
		this.acreage = acreage;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public String getUrl_img1() {
		return url_img1;
	}

	public void setUrl_img1(String url_img1) {
		this.url_img1 = url_img1;
	}

	public String getUrl_img2() {
		return url_img2;
	}

	public void setUrl_img2(String url_img2) {
		this.url_img2 = url_img2;
	}

	public String getUrl_img3() {
		return url_img3;
	}

	public void setUrl_img3(String url_img3) {
		this.url_img3 = url_img3;
	}

	public String getUrl_img4() {
		return url_img4;
	}

	public void setUrl_img4(String url_img4) {
		this.url_img4 = url_img4;
	}

	public String getUrl_img5() {
		return url_img5;
	}

	public void setUrl_img5(String url_img5) {
		this.url_img5 = url_img5;
	}

	public String getUrl_img6() {
		return url_img6;
	}

	public void setUrl_img6(String url_img6) {
		this.url_img6 = url_img6;
	}

	public Home(UUID id, Category category, BusinessType businessType, User user, String name, float length,
			float width, float acreage, String price, Date dateSubmitted, String status, String address,
			String decription, String url_img1, String url_img2, String url_img3, String url_img4, String url_img5,
			String url_img6) {
		super();
		this.id = id;
		this.category = category;
		this.businessType = businessType;
		this.user = user;
		this.name = name;
		this.length = length;
		this.width = width;
		this.acreage = acreage;
		this.price = price;
		this.dateSubmitted = dateSubmitted;
		this.status = status;
		this.address = address;
		this.decription = decription;
		this.url_img1 = url_img1;
		this.url_img2 = url_img2;
		this.url_img3 = url_img3;
		this.url_img4 = url_img4;
		this.url_img5 = url_img5;
		this.url_img6 = url_img6;
	}

	public Home() {
		super();
	}

	@Override
	public String toString() {
		return "Home [id=" + id + ", category=" + category + ", businessType=" + businessType + ", user=" + user
				+ ", name=" + name + ", length=" + length + ", width=" + width + ", acreage=" + acreage + ", price="
				+ price + ", dateSubmitted=" + dateSubmitted + ", status=" + status + ", address=" + address
				+ ", decription=" + decription + ", url_img1=" + url_img1 + ", url_img2=" + url_img2 + ", url_img3="
				+ url_img3 + ", url_img4=" + url_img4 + ", url_img5=" + url_img5 + ", url_img6=" + url_img6 + "]";
	}

}
