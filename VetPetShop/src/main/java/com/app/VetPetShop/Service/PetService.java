package com.app.VetPetShop.Service;

import java.util.List;

import com.app.VetPetShop.DTO.NewPetDto;

public interface PetService {
	
	List<NewPetDto> getAllPets();
	
	List<NewPetDto> getAllPetsOfSeller(Long sellerId);
	
	NewPetDto getPetDetails(Long petId);
	
	String addPets(NewPetDto pet);
	
	String removePet(Long petId);
	
	String updatePetDetails(Long petId, NewPetDto pet);
	
	List<NewPetDto> getAllPetsByBreed(String breedName);
	
	List<NewPetDto> getAllPetsByCategory(String categoryName);

}
