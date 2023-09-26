package com.app.VetPetShop.Pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "UserType")
public class UserType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userTypeId;
	
	@OneToMany(mappedBy = "userTypeId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Users> users = new ArrayList<Users>();
	
	private String userType;
	
	public UserType() {
		super();
	}

	public UserType(String userType) {
		super();
		this.userType = userType;
	}

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void addUser(Users user) {
		users.add(user);
		user.setUserTypeId(this);
	}
	
	public void removeUser(Users user) {
		users.remove(user);
		user.setUserTypeId(null);
	}

	@Override
	public String toString() {
		return "UserType [userTypeId=" + userTypeId + ", users=" + users + ", userType=" + userType + "]";
	}

}
