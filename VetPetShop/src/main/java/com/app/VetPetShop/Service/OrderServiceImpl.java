package com.app.VetPetShop.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.VetPetShop.CustomExceptions.EntityNotFoundException;
import com.app.VetPetShop.DTO.OrdersDto;
import com.app.VetPetShop.Pojos.CartItems;
import com.app.VetPetShop.Pojos.Orders;
import com.app.VetPetShop.Pojos.Payments;
import com.app.VetPetShop.Repositories.CartItemsRepository;
import com.app.VetPetShop.Repositories.OrdersRepository;
import com.app.VetPetShop.Repositories.PaymentsRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrdersRepository orderRepo;
	
	@Autowired
	PaymentsRepository payRepo;
	
	@Autowired
	CartItemsRepository itemRepo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public List<OrdersDto> getAllOrdersOfUser(Long id) {
		List<Orders> orders = orderRepo.findAllByTransactionId_UserId_UserId(id).orElseThrow(()-> new EntityNotFoundException("No orders found for user !!"));
		return orders.stream().map(order -> mapper.map(order, OrdersDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<OrdersDto> getAllOrdersByStatus(String status) {
		List<Orders> orders = orderRepo.findAllByStatusId(status).orElseThrow(()-> new EntityNotFoundException("No orders found for user !!"));
		return orders.stream().map(order -> mapper.map(order, OrdersDto.class)).collect(Collectors.toList());
	}

	@Override
	public OrdersDto getOrderDetails(String id) {
		Orders order = orderRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("No orders found for user !!"));
		OrdersDto orderDto = mapper.map(order, OrdersDto.class);
		return orderDto;
	}

	@Override
	public String updateOrderDetails(OrdersDto order) {
		Orders ordr = orderRepo.findById(order.getOrderId()).orElseThrow(()-> new EntityNotFoundException("Order Not Found !!"));
		ordr.setExpectedDeliveryDate(order.getExpectedDeliveryDate());
		ordr.setShippingAddress(order.getShippingAddress());
		orderRepo.save(ordr);
		return "Order Updated Successfully...";
	}

	@Override
	public String createOrder(OrdersDto order) {
		Payments payment = payRepo.findById(order.getTransactionId()).orElseThrow(()-> new EntityNotFoundException("Payment Not Found !!"));
		CartItems item = itemRepo.findById(order.getItemId()).orElseThrow(()-> new EntityNotFoundException("Cart Item Not Found !!"));
		Orders newOrder = new Orders();
		newOrder.setDiscountGiven(order.getDiscountGiven());
		newOrder.setExpectedDeliveryDate(order.getExpectedDeliveryDate());
		newOrder.setItemId(item);
		newOrder.setOrderDate(order.getOrderDate());
		newOrder.setShippingAddress(order.getShippingAddress());
		newOrder.setTransactionId(payment);
		UUID uniqueId = UUID.randomUUID();
		newOrder.setOrderId(uniqueId.toString());
		orderRepo.save(newOrder);
		return "Order Created Successfully...";
	}

}
