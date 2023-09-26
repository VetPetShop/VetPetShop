package com.app.VetPetShop.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.VetPetShop.Pojos.CartItems;

public interface CartItemsRepository extends JpaRepository<CartItems, Long> {
	
	Optional<List<CartItems>> findAllByCartId_CartId(Long id);
	
	Optional<List<CartItems>> findAllByCartId_UserId_UserId(Long userId);

}
