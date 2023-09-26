package com.app.VetPetShop.DTO;

public class UserLogInDTO {
	
	private String userName;
	
	private String password;

	public UserLogInDTO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public UserLogInDTO() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "UserLogInDTO [userName=" + userName + ", password=" + password + "]";
	}

}
