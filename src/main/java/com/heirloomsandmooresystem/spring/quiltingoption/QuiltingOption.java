package com.heirloomsandmooresystem.spring.quiltingoption;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="quiltingoptions")
public class QuiltingOption {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id = 0;
	
	@Column(length=30, nullable=false)
	private String name = "";
	
	@Column(length=30, nullable=false)
	private String description = "";
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double price = 0;
	
	@Column(length=255, nullable=true)
	private String photoPath = "";
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double discountAvailable = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public double getDiscountAvailable() {
		return discountAvailable;
	}

	public void setDiscountAvailable(double discountAvailable) {
		this.discountAvailable = discountAvailable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}
