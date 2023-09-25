package com.heirloomsandmooresystem.spring.pantographs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="pantographs", uniqueConstraints=@UniqueConstraint(name="UIDX_PartNbr", columnNames= {"partNbr"}))
public class Pantograph {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id = 0;
	
	@Column(length=30, nullable=false)
	private String partNbr = "";
	
	@Column(length=30, nullable=false)
	private String name = "";
	
	@Column(columnDefinition="decimal (11,5) not null")
	private double price = .001;
	
	@Column(length=255, nullable=true)
	private String photoPath = "";
	
	//getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPartNbr() {
		return partNbr;
	}

	public void setPartNbr(String partNbr) {
		this.partNbr = partNbr;
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
	
	
	
}
