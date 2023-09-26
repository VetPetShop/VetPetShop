package com.app.VetPetShop.DTO;

import java.time.LocalDate;

public class UserRequestDto {
	
	private String firstName;
	
	private String lastName;
	
	private char gender;
	
	private String email;
	
	private String password;
	
	private LocalDate dob;
	
	private String address;
	
	private String phoneNumber;
	
	private int userTypeId;

	public UserRequestDto(String firstName, String lastName, char gender, String email, String password, LocalDate dob
			, String phoneNumber, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public UserRequestDto() {
		super();
	}
	
	// it is a good practice to write dto immutable, so we can avoid providing setters and make all the fields final; here we have avoid setters but didn't make use of final data members

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public char getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getUserTypeId() {
		return userTypeId;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "UserDto [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", userTypeId=" + userTypeId + "]";
	}

}
