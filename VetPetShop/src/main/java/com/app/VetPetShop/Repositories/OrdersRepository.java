package com.app.VetPetShop.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.VetPetShop.Pojos.Orders;

public interface OrdersRepository extends JpaRepository<Orders, String> {
	
	Optional<List<Orders>> findAllByTransactionId_UserId_UserId(Long id);
	
	Optional<List<Orders>> findAllByStatusId(String status);

}
