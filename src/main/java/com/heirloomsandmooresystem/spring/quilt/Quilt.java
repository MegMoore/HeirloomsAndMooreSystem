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
	
	@Column(columnDefinition = "boolean", nullable=false)
	private boolean pantograph = false;
	
	@Column(columnDefinition="decimal (11,6) not null")
	private double pantographPrice = 0.002;
	
	@Column(columnDefinition = "boolean", nullable=false)
	private boolean quilting = false;
	
	@Column(columnDefinition="decimal (11,6) not null")
	private double quiltingPrice = 0.002;
	
	@Column(length=400, nullable=false)
	private String quiltingDescription = "";
	
	@Column(columnDefinition = "boolean", nullable=false)
	private boolean binding = false;
	
	@Column(columnDefinition="decimal (11,6) not null")
	private double bindingPrice = 0;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double bindingAmountNeeded = 0;
	
	@Column(columnDefinition = "boolean", nullable=false)
	private boolean backing = false;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double backingPrice = 0;
	
	@Column(columnDefinition = "boolean", nullable=false)
	private boolean batting = false;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double battingPrice = 0;
	
	@Column(length=20, nullable=false)
	private String threadColor = "";
	
	@Column(columnDefinition = "boolean", nullable=false)
	private boolean embroidery = false;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double embroideryPrice = 0;
	
	@Column(length=400, nullable=false)
	private String embroideryDescription = "";
	
	@Column(columnDefinition = "DATETIME (2)")
	private LocalDateTime createdDate = LocalDateTime.now();
	
	@Column(columnDefinition = "DATETIME (2)", nullable=true)
	private LocalDateTime completionDate = createdDate.plus(6, ChronoUnit.WEEKS);
	
	@Column(columnDefinition = "boolean", nullable=false)
	private boolean referral = false;
	
	@Column(length=50, nullable=false)
	private String referralClient = "";
	
	@Column(columnDefinition = "boolean", nullable=false)
	private boolean discount = false;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double discountPrice = 0;
	
	@Column(columnDefinition = "boolean", nullable=false)
	private boolean rewards = false;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double rewardAmount = 20.00;
	
	@Column(length=50, nullable=false)
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
	
	@Column(columnDefinition = "boolean", nullable=false)
	private boolean downpayment = false;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double downpaymentAmount = 0;
	
	@Column(columnDefinition = "boolean", nullable=false)
	private boolean tip = false;
	

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

	public boolean isPantograph() {
		return pantograph;
	}

	public void setPantograph(boolean pantograph) {
		this.pantograph = pantograph;
	}

	public double getPantographPrice() {
		return pantographPrice;
	}

	public void setPantographPrice(double pantographPrice) {
		this.pantographPrice = pantographPrice;
	}

	public boolean isQuilting() {
		return quilting;
	}

	public void setQuilting(boolean quilting) {
		this.quilting = quilting;
	}

	public double getQuiltingPrice() {
		return quiltingPrice;
	}

	public void setQuiltingPrice(double quiltingPrice) {
		this.quiltingPrice = quiltingPrice;
	}

	public String getQuiltingDescription() {
		return quiltingDescription;
	}

	public void setQuiltingDescription(String quiltingDescription) {
		this.quiltingDescription = quiltingDescription;
	}

	public boolean isBinding() {
		return binding;
	}

	public void setBinding(boolean binding) {
		this.binding = binding;
	}

	public double getBindingPrice() {
		return bindingPrice;
	}

	public void setBindingPrice(double bindingPrice) {
		this.bindingPrice = bindingPrice;
	}

	public double getBindingAmountNeeded() {
		return bindingAmountNeeded;
	}

	public void setBindingAmountNeeded(double bindingAmountNeeded) {
		this.bindingAmountNeeded = bindingAmountNeeded;
	}

	public boolean isBacking() {
		return backing;
	}

	public void setBacking(boolean backing) {
		this.backing = backing;
	}

	public double getBackingPrice() {
		return backingPrice;
	}

	public void setBackingPrice(double backingPrice) {
		this.backingPrice = backingPrice;
	}

	public boolean isBatting() {
		return batting;
	}

	public void setBatting(boolean batting) {
		this.batting = batting;
	}

	public double getBattingPrice() {
		return battingPrice;
	}

	public void setBattingPrice(double battingPrice) {
		this.battingPrice = battingPrice;
	}

	public String getThreadColor() {
		return threadColor;
	}

	public void setThreadColor(String threadColor) {
		this.threadColor = threadColor;
	}

	public boolean isEmbroidery() {
		return embroidery;
	}

	public void setEmbroidery(boolean embroidery) {
		this.embroidery = embroidery;
	}

	public double getEmbroideryPrice() {
		return embroideryPrice;
	}

	public void setEmbroideryPrice(double embroideryPrice) {
		this.embroideryPrice = embroideryPrice;
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

	public boolean isReferral() {
		return referral;
	}

	public void setReferral(boolean referral) {
		this.referral = referral;
	}

	public String getReferralClient() {
		return referralClient;
	}

	public void setReferralClient(String referralClient) {
		this.referralClient = referralClient;
	}

	public boolean isDiscount() {
		return discount;
	}

	public void setDiscount(boolean discount) {
		this.discount = discount;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public boolean isRewards() {
		return rewards;
	}

	public void setRewards(boolean rewards) {
		this.rewards = rewards;
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

	public boolean isDownpayment() {
		return downpayment;
	}

	public void setDownpayment(boolean downpayment) {
		this.downpayment = downpayment;
	}

	public double getDownpaymentAmount() {
		return downpaymentAmount;
	}

	public void setDownpaymentAmount(double downpaymentAmount) {
		this.downpaymentAmount = downpaymentAmount;
	}

	public boolean isTip() {
		return tip;
	}

	public void setTip(boolean tip) {
		this.tip = tip;
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
	
	
}
