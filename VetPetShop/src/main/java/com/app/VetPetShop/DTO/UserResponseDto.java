package com.app.VetPetShop.DTO;

import java.time.LocalDate;

public class UserResponseDto {
	
	private Long userId;
	
	private String firstName;
	
	private String lastName;
	
	private char gender;
	
	private String email;
	
	private LocalDate dob;
	
	private String phoneNumber;
	
	private String address;

	public UserResponseDto(Long userId, String firstName, String lastName, char gender, String email, LocalDate dob,
			String phoneNumber, String address) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public UserResponseDto() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserResponseDto [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", email=" + email + ", dob=" + dob + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}

}
