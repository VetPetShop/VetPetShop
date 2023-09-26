package com.app.VetPetShop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.VetPetShop.Pojos.PetCategory;

public interface PetCategoryRepository extends JpaRepository<PetCategory, Integer> {

}
