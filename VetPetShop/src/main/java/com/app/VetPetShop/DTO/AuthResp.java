package com.app.VetPetShop.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthResp {
	private Long id;

	private String email;

	private String firstName;
	private String lastName;

	//private Role role;

	private String token;
}
