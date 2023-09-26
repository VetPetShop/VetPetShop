package com.app.VetPetShop.Pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {
	
	@Id
	private String orderId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transactionId", referencedColumnName = "transactionId")
	private Payments transactionId;
	
	@Column
	private LocalDate orderDate;
	
	@OneToOne(mappedBy = "orderId", cascade = CascadeType.ALL)
	private CartItems itemId;
	
	@Column
	private int discountGiven;
	
	@Column
	private String shippingAddress;
	
	@Column
	private LocalDate expectedDeliveryDate;
	
	@Column
	private String statusId;

	public Orders(LocalDate orderDate, int discountGiven, String shippingAddress, LocalDate expectedDeliveryDate) {
		super();
		this.orderDate = orderDate;
		this.discountGiven = discountGiven;
		this.shippingAddress = shippingAddress;
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public Orders() {
		super();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Payments getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Payments transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public CartItems getItemId() {
		return itemId;
	}

	public void setItemId(CartItems itemId) {
		this.itemId = itemId;
	}

	public int getDiscountGiven() {
		return discountGiven;
	}

	public void setDiscountGiven(int discountGiven) {
		this.discountGiven = discountGiven;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public LocalDate getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", transactionId=" + transactionId + ", orderDate=" + orderDate
				+ ", discountGiven=" + discountGiven + ", shippingAddress=" + shippingAddress
				+ ", expectedDeliveryDate=" + expectedDeliveryDate + "]";
	}

}
