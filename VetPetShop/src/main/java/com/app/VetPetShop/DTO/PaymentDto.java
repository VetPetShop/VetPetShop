package com.app.VetPetShop.DTO;

import java.time.LocalDateTime;

public class PaymentDto {
	
	private String transactionId;
	
	private Long userId;
	
	private double amountPaid;
	
	private LocalDateTime paymentDate;

	public PaymentDto(String transactionId, Long userId, double amountPaid, LocalDateTime paymentDate) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.amountPaid = amountPaid;
		this.paymentDate = LocalDateTime.now();
	}

	public PaymentDto() {
		super();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
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

	@Override
	public String toString() {
		return "PaymentDto [transactionId=" + transactionId + ", userId=" + userId + ", amountPaid=" + amountPaid
				+ ", paymentDate=" + paymentDate + "]";
	}

}
