package com.app.VetPetShop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.VetPetShop.DTO.ApiResponse;
import com.app.VetPetShop.DTO.PaymentDto;
import com.app.VetPetShop.Service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService payService;
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getAllPaymentsOfUser(@PathVariable Long id)
	{
		try {
			return new ResponseEntity<>(payService.getAllTransactionsOfUser(id), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

	
	@GetMapping("/details/{id}")
	public ResponseEntity<?> getPaymentDetails(@PathVariable String id)
	{
		try {
			return new ResponseEntity<>(payService.getPaymentDetails(id), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	

	@PostMapping("/create/{itemId}")
	public ResponseEntity<?> createPayment(@PathVariable Long itemId,@RequestBody PaymentDto payDto)
	{
		try {
			System.out.println(payDto);
			System.out.println("User Id "+payDto.getUserId());
			return new ResponseEntity<>(new ApiResponse(payService.makePayment(payDto, itemId)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}
	

}
