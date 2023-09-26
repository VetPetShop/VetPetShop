package com.app.VetPetShop.Service;

import java.util.List;

import com.app.VetPetShop.DTO.OrdersDto;

public interface OrderService {
	
	List<OrdersDto> getAllOrdersOfUser(Long id);
	
	List<OrdersDto> getAllOrdersByStatus(String status);
	
	OrdersDto getOrderDetails(String id);
	
	String updateOrderDetails(OrdersDto order);
	
	String createOrder(OrdersDto order);

}
