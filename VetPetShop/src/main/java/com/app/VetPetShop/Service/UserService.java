package com.app.VetPetShop.Service;

import java.util.List;

import com.app.VetPetShop.DTO.UserRequestDto;
import com.app.VetPetShop.DTO.UserLogInDTO;
import com.app.VetPetShop.DTO.UserResponseDto;
import com.app.VetPetShop.Pojos.UserType;

public interface UserService {
	
	String registerUser(UserRequestDto user);
	
	UserResponseDto authenticateUser(UserLogInDTO loginDto);
	
	String updateUserDetails(UserRequestDto user);
	
	List<UserRequestDto> getAllUsersByType(UserType typeId); // for doctors
	
	UserResponseDto getUserDetails(String email);
	
	String updateUserType(Long userId, String type);
	
	//String deleteUser(String username, String pass);

}
