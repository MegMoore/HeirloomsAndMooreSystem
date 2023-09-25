package com.heirloomsandmooresystem.spring.client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="clients", uniqueConstraints=@UniqueConstraint(name="UIDX_Username", columnNames= {"username"}))
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id = 0;
	@Column(length=30, nullable=false)
	private String username = "";
	
	@Column(length=30, nullable=false)
	private String firstName = "";
	
	@Column(length=30, nullable=false)
	private String lastName = "";
	
	@Column(length=12, nullable=false)
	private String phone = "";
	
	@Column(length=255, nullable=true)
	private String email = "";
	
	@Column(length=50, nullable=true)
	private String address = "";
	
	@Column(length=2, nullable=true)
	private String state = "OH";
	
	@Column(length=5, nullable=true)
	private String zipCode = "";
	
	@Column(columnDefinition = "boolean", nullable=false)
	private boolean isReviewer = false;
	
	@Column(columnDefinition = "boolean", nullable=false)
	private boolean isAdmin = false;
	
	@Column(columnDefinition="decimal (11,5) not null")
	private double Sales = 0;
	
	
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public boolean isReviewer() {
		return isReviewer;
	}
	public void setReviewer(boolean isReviewer) {
		this.isReviewer = isReviewer;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public double getSales() {
		return Sales;
	}
	public void setSales(double sales) {
		Sales = sales;
	}
	
	
	
	
}


