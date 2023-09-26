package com.app.VetPetShop.Repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.VetPetShop.Pojos.UserType;
import com.app.VetPetShop.Pojos.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	
	Optional<Users> findByEmail(String email);
	
	boolean existsByEmail(String email);
	
	Optional<List<Users>> findAllByUserTypeId(UserType typeId);
	
	Optional<Users> findByUserId(Long userId);
	
	//Optional<Users> findByFirstNameAndLastName(String fnm, String lnm);

}
