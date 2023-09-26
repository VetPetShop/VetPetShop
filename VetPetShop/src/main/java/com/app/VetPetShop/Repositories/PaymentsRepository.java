package com.app.VetPetShop.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.VetPetShop.Pojos.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, String> {
	
	Optional<List<Payments>> findAllByUserId_UserId(Long id);

}
