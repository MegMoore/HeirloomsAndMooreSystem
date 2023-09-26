package com.heirloomsandmooresystem.spring.quilt;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.heirloomsandmooresystem.spring.client.Client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="quilts")
public class Quilt {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double width = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double length = 0;
	
	@Column(length=20, nullable=false)
	private String size = "";
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double area = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double parimeter = 0;
	
	@Column(columnDefinition="decimal (11,6) not null")
	private double pantographPrice = 0.002;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double pantographCost = 0;
	
	@Column(columnDefinition="decimal (11,6) not null")
	private double quiltingPrice = 0.002;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double quiltingCost = 0;
	
	@Column(length=400, nullable=false)
	private String quiltingDescription = "";
	
	@Column(columnDefinition="decimal (11,6) not null")
	private double bindingPrice = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double bindingCost = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double bindingAmountNeeded = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double backingPrice = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double backingCost = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double backingAmountNeeded = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double battingPrice = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double battingCost = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double battingAmountNeeded = 0;
	
	@Column(length=20, nullable=false)
	private String threadColor = "";
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double embroideryCost = 0;
	
	@Column(length=400, nullable=false)
	private String embroideryDescription = "";
	
	@Column(columnDefinition = "DATETIME", nullable=true)
	private LocalDateTime createdDate = LocalDateTime.now();
	
	@Column(columnDefinition = "DATETIME", nullable=true)
	private LocalDateTime completionDate = createdDate.plus(6, ChronoUnit.WEEKS);
	
	@Column(length=50, nullable=false)
	private String referralClient = "";
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double discountPrice = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double discountAmount = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double rewardAmount = 0;
	
	@Column(length=50, nullable=true)
	private String status = "New";
	
	@Column(length=255, nullable=true)
	private String photoPath = "";
	
	@Column(length=255, nullable=true)
	private String comments = "";
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double subTotal = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double totalDue = 0;
	
	@Column(columnDefinition="decimal (11,5) not null")
	private double tax = 0.075;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double taxAmount = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double downpayment = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double downpaymentAmount = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double tip = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double tipAmount = 0;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="clientId")
	private Client client;

	//getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getPantographPrice() {
		return pantographPrice;
	}

	public void setPantographPrice(double pantographPrice) {
		this.pantographPrice = pantographPrice;
	}

	public double getPantographCost() {
		return pantographCost;
	}

	public void setPantographCost(double pantographCost) {
		this.pantographCost = pantographCost;
	}

	public double getQuiltingPrice() {
		return quiltingPrice;
	}

	public void setQuiltingPrice(double quiltingPrice) {
		this.quiltingPrice = quiltingPrice;
	}

	public double getQuiltingCost() {
		return quiltingCost;
	}

	public void setQuiltingCost(double quiltingCost) {
		this.quiltingCost = quiltingCost;
	}

	public String getQuiltingDescription() {
		return quiltingDescription;
	}

	public void setQuiltingDescription(String quiltingDescription) {
		this.quiltingDescription = quiltingDescription;
	}

	public double getBindingPrice() {
		return bindingPrice;
	}

	public void setBindingPrice(double bindingPrice) {
		this.bindingPrice = bindingPrice;
	}

	public double getBindingCost() {
		return bindingCost;
	}

	public void setBindingCost(double bindingCost) {
		this.bindingCost = bindingCost;
	}

	public double getBindingAmountNeeded() {
		return bindingAmountNeeded;
	}

	public void setBindingAmountNeeded(double bindingAmountNeeded) {
		this.bindingAmountNeeded = bindingAmountNeeded;
	}

	public double getBackingPrice() {
		return backingPrice;
	}

	public void setBackingPrice(double backingPrice) {
		this.backingPrice = backingPrice;
	}

	public double getBackingCost() {
		return backingCost;
	}

	public void setBackingCost(double backingCost) {
		this.backingCost = backingCost;
	}

	public double getBattingPrice() {
		return battingPrice;
	}

	public void setBattingPrice(double battingPrice) {
		this.battingPrice = battingPrice;
	}

	public double getBattingCost() {
		return battingCost;
	}

	public void setBattingCost(double battingCost) {
		this.battingCost = battingCost;
	}

	public String getThreadColor() {
		return threadColor;
	}

	public void setThreadColor(String threadColor) {
		this.threadColor = threadColor;
	}

	public double getEmbroideryCost() {
		return embroideryCost;
	}

	public void setEmbroideryCost(double embroideryCost) {
		this.embroideryCost = embroideryCost;
	}

	public String getEmbroideryDescription() {
		return embroideryDescription;
	}

	public void setEmbroideryDescription(String embroideryDescription) {
		this.embroideryDescription = embroideryDescription;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDateTime completionDate) {
		this.completionDate = completionDate;
	}

	public String getReferralClient() {
		return referralClient;
	}

	public void setReferralClient(String referralClient) {
		this.referralClient = referralClient;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public double getRewardAmount() {
		return rewardAmount;
	}

	public void setRewardAmount(double rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getTotalDue() {
		return totalDue;
	}

	public void setTotalDue(double totalDue) {
		this.totalDue = totalDue;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getDownpaymentAmount() {
		return downpaymentAmount;
	}

	public void setDownpaymentAmount(double downpaymentAmount) {
		this.downpaymentAmount = downpaymentAmount;
	}

	public double getTipAmount() {
		return tipAmount;
	}

	public void setTipAmount(double tipAmount) {
		this.tipAmount = tipAmount;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getParimeter() {
		return parimeter;
	}

	public void setParimeter(double parimeter) {
		this.parimeter = parimeter;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getBackingAmountNeeded() {
		return backingAmountNeeded;
	}

	public void setBackingAmountNeeded(double backingAmountNeeded) {
		this.backingAmountNeeded = backingAmountNeeded;
	}

	public double getBattingAmountNeeded() {
		return battingAmountNeeded;
	}

	public void setBattingAmountNeeded(double battingAmountNeeded) {
		this.battingAmountNeeded = battingAmountNeeded;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getDownpayment() {
		return downpayment;
	}

	public void setDownpayment(double downpayment) {
		this.downpayment = downpayment;
	}

	public double getTip() {
		return tip;
	}

	public void setTip(double tip) {
		this.tip = tip;
	}
	

	
	
}
