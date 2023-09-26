package com.app.VetPetShop.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.VetPetShop.Pojos.Users;

//@Getter
public class CustomUserDetails implements UserDetails {
	private Users user;
	

	public CustomUserDetails(Users user) {
		super();
		this.user = user;
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// Can I return List<SimpleGrantedAuthority> ? YESS
//		return List.of(new SimpleGrantedAuthority(user.getRole().name()));
//	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Users getUser() {
		return user;
	}

}
