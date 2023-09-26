package com.app.VetPetShop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.VetPetShop.DTO.ApiResponse;
import com.app.VetPetShop.DTO.CartItemsDto;
import com.app.VetPetShop.Service.CartItemsService;

@RestController
@RequestMapping("/cart")
public class CartItemController {
	
	@Autowired
	private CartItemsService cartService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getAllCartItemsOfUser(@PathVariable Long userId){
		try {
			List<CartItemsDto> items = cartService.getAllCartItems(userId);
			return new ResponseEntity<>(items, HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/item/{id}")
	public ResponseEntity<?> getCartItemDetails(@PathVariable Long id){
		try {
			return new ResponseEntity<>(cartService.getCartItemDetails(id), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	

	@PostMapping("/{userId}/item/add/{petId}")
	public ResponseEntity<?> addCartItem(@PathVariable Long userId, @PathVariable Long petId)
	{
		try {
			return new ResponseEntity<>(new ApiResponse(cartService.addCartItem(petId, userId)), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

	@PostMapping("/{userId}/item/delete/{petId}")
	public ResponseEntity<?> removeCartItem(@PathVariable Long userId, @PathVariable Long petId)
	{
		try {
			return new ResponseEntity<>(new ApiResponse(cartService.removeCartItem(petId, userId)), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	

	@PutMapping("/{itemId}/item/update/{val}")
	public ResponseEntity<?> updateItemQuantity(@PathVariable Long itemId, @PathVariable Boolean val)
	{
		try {
			return new ResponseEntity<>(new ApiResponse(cartService.updateQuantity(itemId, true)), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
}
