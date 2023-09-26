package com.app.VetPetShop.Service;

import java.util.List;

import com.app.VetPetShop.DTO.CartItemsDto;
import com.app.VetPetShop.DTO.NewPetDto;

public interface CartItemsService {
	
	List<CartItemsDto> getAllCartItems(Long id);
	
	NewPetDto getCartItemDetails(Long id);
	
	String addCartItem(Long petId, Long userId);
	
	String removeCartItem(Long itemId, Long userId);
	
	String updateQuantity(Long id, Boolean operator);

}