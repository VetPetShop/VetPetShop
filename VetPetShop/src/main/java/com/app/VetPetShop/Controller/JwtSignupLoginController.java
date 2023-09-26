package com.app.VetPetShop.Controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.VetPetShop.DTO.AuthRequest;
import com.app.VetPetShop.DTO.AuthResp;
import com.app.VetPetShop.DTO.UserRequestDto;
import com.app.VetPetShop.Pojos.Users;
import com.app.VetPetShop.Service.UserService;
import com.app.VetPetShop.jwt_utils.JwtUtils;
import com.app.VetPetShop.security.CustomUserDetails;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/signup-login")
@Slf4j
public class JwtSignupLoginController {
	
	@Autowired
	JwtUtils utils;
	@Autowired
	AuthenticationManager manager;
	@Autowired
	UserService userService;
	@Autowired
	ModelMapper modelMapper;

	
	@PostMapping("/signup")
	public ResponseEntity<?> userRegistration(@RequestBody @Valid UserRequestDto  userAddDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(userAddDto));
	}

	@PostMapping("/login")
	public ResponseEntity<?> validateUserCreateToken(@RequestBody @Valid AuthRequest request) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getEmail(),
				request.getPassword());
		log.info("auth token" + authToken);
		Authentication authentication = manager.authenticate(authToken);
		log.info("auth token again" + authentication.getPrincipal().getClass());
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

		Users user = userDetails.getUser();
		AuthResp resp = modelMapper.map(user, AuthResp.class);
		resp.setToken(utils.generateJwtToken(authentication));
		return ResponseEntity.ok(resp);

	}
	
}
