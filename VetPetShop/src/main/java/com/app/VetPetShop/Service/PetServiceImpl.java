package com.app.VetPetShop.Service;

import java.util.List;
import java.util.stream.Collectors;

//import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.VetPetShop.CustomExceptions.EntityNotFoundException;
import com.app.VetPetShop.DTO.NewPetDto;
import com.app.VetPetShop.Pojos.PetBreed;
import com.app.VetPetShop.Pojos.Pets;
import com.app.VetPetShop.Pojos.Sellers;
import com.app.VetPetShop.Repositories.PetBreedRepository;
import com.app.VetPetShop.Repositories.PetRepository;
import com.app.VetPetShop.Repositories.SellerRepository;
import com.app.VetPetShop.Repositories.UserRepository;

@Service
@Transactional
public class PetServiceImpl implements PetService{
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	PetRepository petRepo;
	
	@Autowired
	SellerRepository sellerRepo;
	
	@Autowired
	PetBreedRepository breedRepo;
	
	@Autowired
	UserRepository userRepo;

	@Override
	public List<NewPetDto> getAllPets() {
		List<Pets> allPets = petRepo.findAll();
		
//		allPets.forEach(pet -> {
//	        Hibernate.initialize(pet.getBreedId());
//	        Hibernate.initialize(pet.getSellerId());
//	    });
		
		return allPets.stream().map(pet -> mapper.map(pet, NewPetDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<NewPetDto> getAllPetsOfSeller(Long id) {
		List<Pets> pets = petRepo.findAllBySellerId_SellerId_UserId(id).orElseThrow(()-> new EntityNotFoundException("No pets found for the give seller"));
		return pets.stream().map(pet -> mapper.map(pet, NewPetDto.class)).collect(Collectors.toList());
	}

	@Override
	public NewPetDto getPetDetails(Long petId) {
		Pets pet = petRepo.findById(petId).orElseThrow(()-> new EntityNotFoundException("Pet not found !!"));
		
		NewPetDto petdto = mapper.map(pet, NewPetDto.class);
		return petdto;
	}

	@Override
	public String addPets(NewPetDto petdto) {
		Pets pet = mapper.map(petdto, Pets.class);
		
		PetBreed breed = breedRepo.findByBreedName(petdto.getBreedName()).orElseThrow(() -> new EntityNotFoundException("Breed not found"));
		pet.setBreedId(breed);
		
		//Users seller = userRepo.findByEmail(petdto.getEmail()).orElseThrow(() -> new EntityNotFoundException("User not found"));
		
		Sellers s = sellerRepo.findBySellerId_Email(petdto.getEmail()).orElseThrow(() -> new EntityNotFoundException("Seller not found"));
		
		pet.setSellerId(s);
		
		Pets savePet = petRepo.save(pet);
		
		return "Pet added successfully with id "+savePet.getPetId();
	}

	@Override
	public String removePet(Long petId) {
		Pets pet = petRepo.findById(petId).orElseThrow(()-> new EntityNotFoundException("Pet Not found !!"));
		petRepo.delete(pet);
		return "Pet Removed Successfully...";
	}

	@Override
	public String updatePetDetails(Long petId, NewPetDto petDto) {
		Pets pet = petRepo.findById(petId).orElseThrow(()-> new EntityNotFoundException("Pet Not found !!"));
		
		pet.setDescription(petDto.getDescription());
		pet.setHeight(petDto.getHeight());
		pet.setPetAge(petDto.getPetAge());
	    pet.setGender(petDto.getGender());
	    pet.setWeight(petDto.getWeight());
	    pet.setPetColour(petDto.getPetColour());
	    pet.setMedicalDetails(petDto.getMedicalDetails());
	    pet.setPrice(petDto.getPrice());
		// remaining fields such as breed and seller cannot be changed
	    petRepo.save(pet);
		return "Pet details are updated successully for petId : "+pet.getPetId();
	}

	@Override
	public List<NewPetDto> getAllPetsByBreed(String breedName) {
		PetBreed breed = breedRepo.findByBreedName(breedName).orElseThrow(()-> new EntityNotFoundException("Breed Not found !!"));
		List<Pets> pets = petRepo.findAllByBreedId(breed).orElseThrow(()-> new EntityNotFoundException("No pets for given breed found !!"));
		
		return pets.stream().map(pet -> mapper.map(pet, NewPetDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<NewPetDto> getAllPetsByCategory(String categoryName) {
		List<Pets> pets = petRepo.findAllByBreedId_PetCategoryId_PetCategory(categoryName).orElseThrow(()-> new EntityNotFoundException("No pets for given Category found !!"));
		return pets.stream().map(pet -> mapper.map(pet, NewPetDto.class)).collect(Collectors.toList());
	}

}
