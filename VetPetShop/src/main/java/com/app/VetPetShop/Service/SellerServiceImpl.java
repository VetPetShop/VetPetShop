//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

//package com.app.VetPetShop.Service;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.app.VetPetShop.CustomExceptions.EntityNotFoundException;
//import com.app.VetPetShop.DTO.NewSellerDto;
//import com.app.VetPetShop.Pojos.Sellers;
//import com.app.VetPetShop.Pojos.Users;
//import com.app.VetPetShop.Repositories.SellerRepository;
//
//  @Service
//  @Transactional
//public class SellerServiceImpl implements SellerService {
//	
//	@Autowired
//	private ModelMapper mapper;
//	
//	@Autowired
//	private SellerRepository sellerRepo;
//
//	@Override
//	public Sellers getSellerDetails(Users sellerId) { //need to create a constructor for sellerId
//		Sellers seller = sellerRepo.findBySellerId(sellerId).orElseThrow(()-> new EntityNotFoundException("Seller Not Found !!"));
//		return seller;
//	}
//
//	@Override
//	public String updateTotalSales(Users sellerId, int sales) {
//		Sellers seller = sellerRepo.findBySellerId(sellerId).orElseThrow(()-> new EntityNotFoundException("Seller Not Found !!"));
//		seller.setTotalSales(seller.getTotalSales() + sales);
//		sellerRepo.save(seller);
//		return "Total Sales Updated Successfully...";
//	}
//
//	@Override
//	public String registerSeller(NewSellerDto seller) {
//		Sellers newSeller = mapper.map(seller, Sellers.class);
//		sellerRepo.save(newSeller);
//		return "Seller Registered Successfully...";
//	}
//
//	@Override
//	public String deleteSeller(Users sellerId) {
//		Sellers seller = sellerRepo.findBySellerId(sellerId).orElseThrow(()-> new EntityNotFoundException("Seller Not Found !!"));
//		sellerRepo.delete(seller);
//		return "Seller Deleted Successfully...";
//	}
//
//}
