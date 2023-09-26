package com.app.VetPetShop.Service;

import java.util.List;

import com.app.VetPetShop.DTO.PaymentDto;

public interface PaymentService {
	
	List<PaymentDto> getAllTransactionsOfUser(Long id);
	
	PaymentDto getPaymentDetails(String id);
	
	String makePayment(PaymentDto pay, Long itemId);

}
