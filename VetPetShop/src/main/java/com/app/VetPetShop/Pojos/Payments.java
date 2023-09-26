package com.app.VetPetShop.Pojos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Payments")
public class Payments {
	
	@Id
	private String transactionId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private Users userId;
	
	@Column
	private double amountPaid;
	
	@Column
	private LocalDateTime paymentDate;
	
	@OneToMany(mappedBy = "transactionId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Orders> orders = new ArrayList<Orders>();

	public Payments(double amountPaid, LocalDateTime paymentDate) {
		super();
		this.amountPaid = amountPaid;
		this.paymentDate = LocalDateTime.now();
	}

	public Payments() {
		super();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public void makeOrder(Orders order)
	{
		orders.add(order);
		order.setTransactionId(this);
	}

	@Override
	public String toString() {
		return "Payments [transactionId=" + transactionId + ", userId=" + userId + ", amountPaid=" + amountPaid
				+ ", paymentDate=" + paymentDate + ", orders=" + orders + "]";
	}

}
