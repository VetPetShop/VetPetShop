package com.app.VetPetShop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.VetPetShop.DTO.ApiResponse;
import com.app.VetPetShop.DTO.NewPetDto;
import com.app.VetPetShop.Service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {
	
	@Autowired
	private PetService petService;
	
	@GetMapping
	public ResponseEntity<?> getAllPets(){
		try {
			List<NewPetDto> pets = petService.getAllPets();
			return new ResponseEntity<>(pets, HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/{sellerId}")
	public ResponseEntity<?> getAllPetsOfSeller(@PathVariable Long sellerId){
		try {
			return new ResponseEntity<>(petService.getAllPetsOfSeller(sellerId), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/pet/{petId}")
	public ResponseEntity<?> getPetDetails(@PathVariable Long petId){
		try {
			return new ResponseEntity<>(petService.getPetDetails(petId), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addPet(@RequestBody NewPetDto petDto){
		
		try {
			return new ResponseEntity<>(new ApiResponse(petService.addPets(petDto)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
		
	}
	
	@DeleteMapping("/delete/{petId}")
	public ResponseEntity<?> removePet(@PathVariable Long petId){
		
		try {
			return new ResponseEntity<>(new ApiResponse(petService.removePet(petId)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
		
	}
	
	@PutMapping("/update/{petId}/")
	public ResponseEntity<?> UpdatePetDetails(@PathVariable Long petId,@RequestBody NewPetDto petDto){
		
		try {
			return new ResponseEntity<>(new ApiResponse(petService.updatePetDetails(petId, petDto)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
		
	}
	
	@GetMapping("/breed/{breedName}")
	public ResponseEntity<?> getAllPetsByBreed(@PathVariable String breedName){
		try {
			return new ResponseEntity<>(petService.getAllPetsByBreed(breedName), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/category/{categoryName}")
	public ResponseEntity<?> getAllPetsByCategory(@PathVariable String categoryName)
	{
		try {
			return new ResponseEntity<>(petService.getAllPetsByCategory(categoryName), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

}
