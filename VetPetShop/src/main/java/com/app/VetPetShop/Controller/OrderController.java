package com.app.VetPetShop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.VetPetShop.DTO.ApiResponse;
import com.app.VetPetShop.DTO.OrdersDto;
import com.app.VetPetShop.Service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrdersForUser(@PathVariable Long id)
	{
		try {
			return new ResponseEntity<>(orderService.getAllOrdersOfUser(id), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

	@GetMapping("/status/{status}")
	public ResponseEntity<?> getOrdersByStatus(@PathVariable String status)
	{
		try {
			return new ResponseEntity<>(orderService.getAllOrdersByStatus(status), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<?> getOrderDetails(@PathVariable String id)
	{
		try {
			return new ResponseEntity<>(orderService.getOrderDetails(id), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateOrderDetails(@RequestBody OrdersDto order)
	{
		try {
			return new ResponseEntity<>(new ApiResponse(orderService.updateOrderDetails(order)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}

	@PostMapping("/neworder")
	public ResponseEntity<?> createOrder(@RequestBody OrdersDto order)
	{
		try {
			return new ResponseEntity<>(new ApiResponse(orderService.createOrder(order)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}

}
