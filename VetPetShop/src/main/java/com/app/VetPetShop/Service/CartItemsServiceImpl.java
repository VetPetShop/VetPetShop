package com.app.VetPetShop.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.VetPetShop.CustomExceptions.EntityNotFoundException;
import com.app.VetPetShop.DTO.CartItemsDto;
import com.app.VetPetShop.DTO.NewPetDto;
import com.app.VetPetShop.Pojos.Cart;
import com.app.VetPetShop.Pojos.CartItems;
import com.app.VetPetShop.Pojos.Pets;
import com.app.VetPetShop.Repositories.CartItemsRepository;
import com.app.VetPetShop.Repositories.CartRepository;
import com.app.VetPetShop.Repositories.PetRepository;

@Service
@Transactional
public class CartItemsServiceImpl implements CartItemsService {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	PetRepository petRepo;
	
	@Autowired
	CartItemsRepository itemRepo;
	
	@Autowired
	CartRepository cartRepo;

	@Override
	public List<CartItemsDto> getAllCartItems(Long id) {
		//Cart cart = cartRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Cart not found !!"));
		List<CartItems> items = itemRepo.findAllByCartId_UserId_UserId(id).orElseThrow(()-> new EntityNotFoundException("items not found !!"));
		
		return items.stream().map(item -> mapper.map(item, CartItemsDto.class)).collect(Collectors.toList());
	}

	@Override
	public NewPetDto getCartItemDetails(Long id) {
		CartItems item = itemRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("item not found !!"));
		Pets pet = petRepo.findById(item.getPetId().getPetId()).orElseThrow(()-> new EntityNotFoundException("Pet not found !!"));
		NewPetDto cartPet = mapper.map(pet, NewPetDto.class);
		return cartPet;
	}

	@Override
	public String addCartItem(Long petId, Long userId) {
		
		Cart cart = cartRepo.findByUserId_UserId(userId).orElseThrow(()-> new EntityNotFoundException("Cart not found !!"));
		CartItems item = new CartItems();
		item.setCartId(cart);
		Pets pet = petRepo.findById(petId).orElseThrow(()-> new EntityNotFoundException("Pet not found !!"));
		item.setPetId(pet);
		item.setQuantity(1);
		itemRepo.save(item);
		cart.setTotalItems(cart.getTotalItems()+1);
		return "Item added Successfully";
	}
	
	@Override
	public String removeCartItem(Long itemId, Long userId) {
		Cart cart = cartRepo.findByUserId_UserId(userId).orElseThrow(()-> new EntityNotFoundException("Cart not found !!"));
		CartItems item = itemRepo.findById(itemId).orElseThrow(()-> new EntityNotFoundException("item Not Found !!"));
		itemRepo.delete(item);
		cart.setTotalItems(cart.getTotalItems()-1);
		return "Item removed Successfully";
	}

	@Override
	public String updateQuantity(Long id, Boolean operator) {
		CartItems item = itemRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Item not found !!"));
		if (operator) {
			item.setQuantity(item.getQuantity()+1); // plus button pressed
		} else {
			item.setQuantity(item.getQuantity()-1); // minus button pressed
		}
		itemRepo.save(item);
		return "Quantity updated successfully...";
	}

}
