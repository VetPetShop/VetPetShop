package com.app.VetPetShop.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.VetPetShop.CustomExceptions.EntityNotFoundException;
import com.app.VetPetShop.DTO.OrdersDto;
import com.app.VetPetShop.DTO.PaymentDto;
import com.app.VetPetShop.Pojos.Payments;
import com.app.VetPetShop.Pojos.Users;
import com.app.VetPetShop.Repositories.PaymentsRepository;
import com.app.VetPetShop.Repositories.UserRepository;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	PaymentsRepository payRepo;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	UserRepository userRepo;

	@Override
	public List<PaymentDto> getAllTransactionsOfUser(Long id) {
		List<Payments> payments = payRepo.findAllByUserId_UserId(id).orElseThrow(()-> new EntityNotFoundException("No payments found for user !!"));
		return payments.stream().map(payment -> mapper.map(payment, PaymentDto.class)).collect(Collectors.toList());
	}

	@Override
	public PaymentDto getPaymentDetails(String id) {
		Payments payment = payRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Payment Not Found !!"));
		PaymentDto pay = mapper.map(payment, PaymentDto.class);
		return pay;
	}

	@Override 
	public String makePayment(PaymentDto pay, Long itemId) {
		System.out.println(pay);
		System.out.println("User Id "+pay.getUserId());
		Users user = userRepo.findById(pay.getUserId()).orElseThrow(()-> new EntityNotFoundException("User Not Found !!"));
		
		Payments payment = new Payments();
		payment.setUserId(user);
		payment.setPaymentDate(LocalDateTime.now());
		payment.setAmountPaid(pay.getAmountPaid());
		UUID uniqueId = UUID.randomUUID();
		payment.setTransactionId(uniqueId.toString());
		payRepo.save(payment);
		String msg = "Payment Successfull ";
		OrdersDto orderDto = new OrdersDto();
		
		orderDto.setTransactionId(payment.getTransactionId());
		orderDto.setDiscountGiven(10);
		LocalDateTime paymentDate = payment.getPaymentDate();
		LocalDate expectedDeliveryDate = paymentDate.toLocalDate().plusDays(10);
		orderDto.setExpectedDeliveryDate(expectedDeliveryDate);
		orderDto.setOrderDate(expectedDeliveryDate.minusDays(10));
		orderDto.setItemId(itemId);
		orderDto.setShippingAddress(user.getAddress());
		orderDto.setStatusId(1);
		orderService.createOrder(orderDto);
		msg+="Order placed";
		return msg;
	}

}
