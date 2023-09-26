package com.app.VetPetShop.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.VetPetShop.Pojos.PetBreed;
import com.app.VetPetShop.Pojos.PetCategory;

public interface PetBreedRepository extends JpaRepository<PetBreed, Integer> {
	
	Optional<List<PetBreed>> findAllByPetCategoryId(PetCategory id);
	
	Optional<PetBreed> findByBreedName(String name);

}
