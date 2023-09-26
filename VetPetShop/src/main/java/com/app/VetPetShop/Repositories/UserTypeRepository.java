package com.app.VetPetShop.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.VetPetShop.Pojos.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
	
	Optional<UserType> findByUserType(String type);

}
