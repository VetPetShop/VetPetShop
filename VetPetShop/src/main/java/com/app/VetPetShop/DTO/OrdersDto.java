package com.app.VetPetShop.DTO;

import java.time.LocalDate;

public class OrdersDto {
	
private String orderId;
	
	private String transactionId;
	
	private LocalDate orderDate;
	
	private Long itemId;
	
	private int discountGiven;
	
	private String shippingAddress;
	
	private LocalDate expectedDeliveryDate;
	
	private int statusId;

	public OrdersDto(String orderId, String transactionId, LocalDate orderDate, Long itemId, int discountGiven,
			String shippingAddress, LocalDate expectedDeliveryDate, int statusId) {
		super();
		this.orderId = orderId;
		this.transactionId = transactionId;
		this.orderDate = orderDate;
		this.itemId = itemId;
		this.discountGiven = discountGiven;
		this.shippingAddress = shippingAddress;
		this.expectedDeliveryDate = expectedDeliveryDate;
		this.statusId = statusId;
	}

	public OrdersDto() {
		super();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
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

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Override
	public String toString() {
		return "OrdersDto [orderId=" + orderId + ", transactionId=" + transactionId + ", orderDate=" + orderDate
				+ ", itemId=" + itemId + ", discountGiven=" + discountGiven + ", shippingAddress=" + shippingAddress
				+ ", expectedDeliveryDate=" + expectedDeliveryDate + ", statusId=" + statusId + "]";
	}

}
