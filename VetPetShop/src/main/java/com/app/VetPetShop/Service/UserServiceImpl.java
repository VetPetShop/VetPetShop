package com.app.VetPetShop.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.VetPetShop.CustomExceptions.EntityNotFoundException;
import com.app.VetPetShop.CustomExceptions.RequestFailed;
import com.app.VetPetShop.DTO.UserRequestDto;
import com.app.VetPetShop.DTO.UserLogInDTO;
import com.app.VetPetShop.DTO.UserResponseDto;
import com.app.VetPetShop.Pojos.Cart;
import com.app.VetPetShop.Pojos.Sellers;
import com.app.VetPetShop.Pojos.UserType;
import com.app.VetPetShop.Pojos.Users;
import com.app.VetPetShop.Repositories.CartRepository;
import com.app.VetPetShop.Repositories.SellerRepository;
import com.app.VetPetShop.Repositories.UserRepository;
import com.app.VetPetShop.Repositories.UserTypeRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SellerRepository sellerRepo;
	
	@Autowired
	private UserTypeRepository typeRepo;
	
	@Autowired
	private CartRepository cartRepo;

	@Override
	public String registerUser(UserRequestDto user) {
		if(userRepo.existsByEmail(user.getEmail().toLowerCase()))
		{
			return "User already exists !!";
		}
		else {
			
			UserType usertype = typeRepo.findByUserType("CUSTOMER").orElseThrow(()-> new EntityNotFoundException("User Type not found !!"));
			
			Users user1 = mapper.map(user, Users.class);
			user1.setUserTypeId(usertype);
			Cart cart = new Cart();
			Users user2 = userRepo.save(user1);
			cart.setUserId(user2);
			cart.setTotalItems(0);
			cartRepo.save(cart);
			if(user2.getUserTypeId().getUserType().equals("SELLER"))
			{
				Sellers seller = new Sellers();
				UUID uniqueId = UUID.randomUUID();
				seller.setGstNo(uniqueId.toString());
				seller.setSellerId(user2);
				seller.setSellerPolicy("no policy");
				seller.setTotalSales(0);
				sellerRepo.save(seller);
			}
			return user2.getFirstName()+" Registered Successfully and Cart Created...";
		}
	}

	@Override
	public UserResponseDto authenticateUser(UserLogInDTO loginDto) {
		Users user = userRepo.findByEmail(loginDto.getUserName()).orElseThrow(()-> new EntityNotFoundException("Invalid Username !!"));
		if(user.getPassword().equals(loginDto.getPassword()))
		{
			UserResponseDto userResponse = mapper.map(user, UserResponseDto.class);
			return userResponse;
		}
		throw new EntityNotFoundException("Invalid Credentials !!");
	}

	@Override
	public String updateUserDetails(UserRequestDto userData) {
		Users user = userRepo.findByEmail(userData.getEmail()).orElseThrow(()-> new EntityNotFoundException("Invalid Username !!"));
		if(user != null)
		{
			//email is the username and cannot be changed
			user.setDob(userData.getDob());
			user.setFirstName(userData.getFirstName());
			user.setLastName(userData.getLastName());
			user.setPassword(userData.getPassword());
			user.setPhoneNumber(userData.getPhoneNumber());
			user.setGender(userData.getGender());
			user.setAddress(userData.getAddress());
			userRepo.save(user);
			return "Details updated Successfully...";
		}
		throw new RequestFailed("Details could not be updated !!");
	}

	@Override
	public UserResponseDto getUserDetails(String email) {
		Users user = userRepo.findByEmail(email).orElseThrow(()-> new EntityNotFoundException("Invalid Username !!"));
		UserResponseDto userResponse = mapper.map(user, UserResponseDto.class);
		return userResponse;
	}

	@Override
	public List<UserRequestDto> getAllUsersByType(UserType typeId) {
		List<Users> users = userRepo.findAllByUserTypeId(typeId).orElseThrow(()-> new EntityNotFoundException("No Doctors available !!"));
		return users.stream().map(user -> mapper.map(user, UserRequestDto.class)).collect(Collectors.toList());
	}

	@Override
	public String updateUserType(Long userId, String type) {
		Users user = userRepo.findById(userId).orElseThrow(()-> new EntityNotFoundException("User Not Found !!"));
		UserType usertype = typeRepo.findByUserType(type.toUpperCase()).orElseThrow(()-> new EntityNotFoundException("User Type not found !!"));
		user.setUserTypeId(usertype);
		userRepo.save(user);
		if(user.getUserTypeId().getUserType().equals("SELLER"))
		{
			Sellers seller = new Sellers();
			UUID uniqueId = UUID.randomUUID();
			seller.setGstNo(uniqueId.toString());
			seller.setSellerId(user);
			seller.setSellerPolicy("no policy");
			seller.setTotalSales(0);
			sellerRepo.save(seller);
		}
		return "User Type updated successfully...";
	}

}
