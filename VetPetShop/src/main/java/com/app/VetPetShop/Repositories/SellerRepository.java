package com.app.VetPetShop.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.VetPetShop.Pojos.Sellers;
import com.app.VetPetShop.Pojos.Users;

public interface SellerRepository extends JpaRepository<Sellers, String> {
	
	Optional<Sellers> findBySellerId_UserId(Users sellerId);
	
	Optional<Sellers> findBySellerId_Email(String email);

}
