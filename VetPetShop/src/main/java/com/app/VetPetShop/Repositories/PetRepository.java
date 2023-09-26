package com.app.VetPetShop.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.VetPetShop.Pojos.PetBreed;
import com.app.VetPetShop.Pojos.Pets;
import com.app.VetPetShop.Pojos.Sellers;

public interface PetRepository extends JpaRepository<Pets, Long> {
	
	Optional<List<Pets>> findAllBySellerId(Sellers id);
	
	Optional<List<Pets>> findAllBySellerId_SellerId_UserId(Long id);
	
	Optional<List<Pets>> findAllByBreedId(PetBreed id);
	
	Optional<List<Pets>> findAllByPetColour(String colour);
	
	Optional<List<Pets>> findAllByBreedId_PetCategoryId_PetCategory(String category);

}
