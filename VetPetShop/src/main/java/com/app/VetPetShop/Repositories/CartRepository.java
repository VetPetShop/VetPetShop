package com.app.VetPetShop.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.VetPetShop.Pojos.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	Optional<Cart> findByUserId_UserId(Long id);

}
